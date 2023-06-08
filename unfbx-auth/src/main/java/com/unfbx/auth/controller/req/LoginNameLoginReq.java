package com.unfbx.auth.controller.req;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginNameLoginReq extends LoginReq{
    @NotBlank(message = "用户名不能为空")
    private String loginName;
    @NotBlank(message = "密码不能为空")
    private String password;
}
