package com.unfbx.common.core.exception;

import com.unfbx.common.core.enums.IError;

public class BaseException extends RuntimeException {

    private String msg;
    private int code;

    public BaseException(IError error) {
        super(error.msg());
        this.code = error.code();
        this.msg = error.msg();
    }

    public BaseException(String msg) {
        super(msg);
        this.code = 500;
        this.msg = msg;
    }
}
