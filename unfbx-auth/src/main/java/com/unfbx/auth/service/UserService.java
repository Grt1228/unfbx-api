package com.unfbx.auth.service;

import com.unfbx.auth.controller.req.LoginNameLoginReq;
import com.unfbx.auth.controller.resp.LoginResp;
import com.unfbx.auth.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

public interface UserService extends IService<User> {

    LoginResp login(LoginNameLoginReq req);

    User queryByUserNameAndPwd(String username,String pwd);

    User queryByEmailAndPwd(String email,String pwd);
}
