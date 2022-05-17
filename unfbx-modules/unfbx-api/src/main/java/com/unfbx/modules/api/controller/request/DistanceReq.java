package com.unfbx.modules.api.controller.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class DistanceReq {
    @NotBlank(message = "经纬度参数异常")
    private String longitudeStart;
    @NotBlank(message = "经纬度参数异常")
    private String latitudeStart;
    @NotBlank(message = "经纬度参数异常")
    private String longitudeEnd;
    @NotBlank(message = "经纬度参数异常")
    private String latitudeEnd;
}
