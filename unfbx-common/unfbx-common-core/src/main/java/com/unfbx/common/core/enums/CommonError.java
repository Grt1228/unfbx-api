package com.unfbx.common.core.enums;

public enum CommonError implements IError {
    SYS_ERROR(500, "系统繁忙");


    private int code;
    private String msg;

    CommonError(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String msg() {
        return null;
    }

    @Override
    public int code() {
        return 0;
    }
}
