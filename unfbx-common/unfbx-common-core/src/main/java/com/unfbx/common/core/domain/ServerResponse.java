package com.unfbx.common.core.domain;

import com.unfbx.common.core.constant.Constants;

import java.io.Serializable;

/**
 * 描述：
 *
 * @author grt
 * @date 2022-05-06
 */
public class ServerResponse<T> implements Serializable {
    private String msg;
    private int code;
    private T data;

    public enum Type {
        SUCCESS(0, Constants.SUCCESS),
        ERROR(500, Constants.ERROR),
        ;
        private final int value;
        private final String desc;

        Type(int value,String desc) {
            this.value = value;
            this.desc = desc;
        }

        public int value() {
            return this.value;
        }
    }

    private ServerResponse() {
    }

    private ServerResponse(String msg) {
        this.msg = msg;
    }

    private ServerResponse(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }

    private ServerResponse(String msg, int code, T data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public static <T> ServerResponse<T> success( T data) {
        return new ServerResponse(Type.SUCCESS.desc, Type.SUCCESS.value(), data);
    }

    public static <T> ServerResponse<T> success() {
        return new ServerResponse(Type.SUCCESS.desc, Type.SUCCESS.value(), null);
    }

    public static <T> ServerResponse<T> error() {
        return new ServerResponse(Type.SUCCESS.desc, Type.ERROR.value(), null);
    }

    public static <T> ServerResponse<T> error(String msg) {
        return new ServerResponse(msg, Type.ERROR.value(), null);
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    public T getData() {
        return data;
    }
}
