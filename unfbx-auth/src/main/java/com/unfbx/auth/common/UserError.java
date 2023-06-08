package com.unfbx.auth.common;

import com.unfbx.common.core.enums.IError;

/**
 * 用户系统错误码
 * 100 标识用户系统
 * 0001标识错误码
 */
public enum UserError implements IError {
    USER_NOT_EXIST(1000001, "用户名密码不存在");

    private int code;
    private String msg;

    UserError(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String msg() {
        return this.msg;
    }

    @Override
    public int code() {
        return this.code;
    }
}
