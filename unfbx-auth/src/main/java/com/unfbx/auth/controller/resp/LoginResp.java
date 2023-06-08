package com.unfbx.auth.controller.resp;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResp {
    private String userName;
    private String token;
    private String resource;
}
