package com.unfbx.auth.service.impl;

import com.unfbx.auth.controller.req.LoginNameLoginReq;
import com.unfbx.auth.entity.User;
import com.unfbx.auth.service.UserService;
import com.unfbx.jd.asynctool.callback.ICallback;
import com.unfbx.jd.asynctool.callback.IWorker;
import com.unfbx.jd.asynctool.worker.WorkResult;
import com.unfbx.jd.asynctool.wrapper.WorkerWrapper;

import java.util.Map;

public class UserNameLoginWork implements IWorker<LoginNameLoginReq, User>, ICallback<LoginNameLoginReq, User> {

    private UserService userService;

    public UserNameLoginWork(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void begin() {
        ICallback.super.begin();
    }

    @Override
    public void result(boolean success, LoginNameLoginReq param, WorkResult<User> workResult) {
    }

    @Override
    public User action(LoginNameLoginReq req, Map<String, WorkerWrapper> allWrappers) {
        User user = this.userService.queryByUserNameAndPwd(req.getLoginName(), req.getPassword());
        return user;
    }

    @Override
    public User defaultValue() {
        return null;
    }
}
