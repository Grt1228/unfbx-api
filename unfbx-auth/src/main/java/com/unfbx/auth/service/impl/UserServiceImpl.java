package com.unfbx.auth.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.unfbx.auth.common.UserError;
import com.unfbx.auth.controller.req.LoginNameLoginReq;
import com.unfbx.auth.controller.resp.LoginResp;
import com.unfbx.auth.service.UserService;
import com.unfbx.auth.utils.PwdUtils;
import com.unfbx.common.core.domain.BaseEntity;
import com.unfbx.common.core.exception.BaseException;
import com.unfbx.jd.asynctool.executor.Async;
import com.unfbx.jd.asynctool.wrapper.WorkerWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.unfbx.auth.mapper.UserMapper;
import com.unfbx.auth.entity.User;

import java.util.Objects;
import java.util.concurrent.ExecutionException;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    @Override
    public LoginResp login(LoginNameLoginReq req) {

        EmailLoginWork emailLoginWork = new EmailLoginWork(this);
        UserNameLoginWork userNameLoginWork = new UserNameLoginWork(this);
        WorkerWrapper<LoginNameLoginReq, User> userNameWrapper = new WorkerWrapper.Builder()
                .worker(userNameLoginWork)
                .callback(emailLoginWork)
                .param(req)
                .build();

        WorkerWrapper<LoginNameLoginReq, User> emailWrapper = new WorkerWrapper.Builder()
                .worker(emailLoginWork)
                .callback(emailLoginWork)
                .param(req)
                .build();
        try {
            Async.beginWork(1500, userNameWrapper, emailWrapper);
            User user = userNameWrapper.getWorkResult().getResult();
            if (Objects.nonNull(user)) {
                StpUtil.login(user.getUserId());
                return LoginResp.builder().userName(user.getUserName()).token(StpUtil.getTokenInfo().getTokenValue()).build();
            }
            user = emailWrapper.getWorkResult().getResult();
            if (Objects.nonNull(user)) {
                StpUtil.login(user.getUserId());
                return LoginResp.builder().userName(user.getUserName()).token(StpUtil.getTokenInfo().getTokenValue()).build();
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        throw new BaseException(UserError.USER_NOT_EXIST);
    }

    @Override
    public User queryByUserNameAndPwd(String username, String pwd) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserName, username);
        queryWrapper.eq(User::getPassword, PwdUtils.md5Asc(pwd));
        queryWrapper.eq(User::getDeleted, BaseEntity.Deleted.NORMAL.code());
        return this.getOne(queryWrapper);
    }

    @Override
    public User queryByEmailAndPwd(String email, String pwd) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getEmail, email);
        queryWrapper.eq(User::getPassword, PwdUtils.md5Asc(pwd));
        queryWrapper.eq(User::getDeleted, BaseEntity.Deleted.NORMAL.code());
        return this.getOne(queryWrapper);
    }
}
