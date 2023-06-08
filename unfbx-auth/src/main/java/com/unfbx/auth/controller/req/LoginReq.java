package com.unfbx.auth.controller.req;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class LoginReq {
    @NotNull(message = "登录方式未选择")
    private Integer loginType;
}
