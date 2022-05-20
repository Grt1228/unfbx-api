package com.unfbx.modules.api.controller.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class IpReq {
    @NotBlank(message = "ip地址不能为空")
    private String ip;
}
