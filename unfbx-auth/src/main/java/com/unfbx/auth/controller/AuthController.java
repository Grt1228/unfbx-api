package com.unfbx.auth.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.unfbx.auth.controller.req.LoginNameLoginReq;
import com.unfbx.auth.controller.resp.LoginResp;
import com.unfbx.auth.service.UserService;
import com.unfbx.common.core.domain.ServerResponse;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // 登录
    @PostMapping("/login")
    public ServerResponse<LoginResp> login(@RequestBody LoginNameLoginReq req) {
        LoginResp resp = userService.login(req);
        return ServerResponse.success(resp);
    }

    @GetMapping("/logout")
    public ServerResponse logout() {
        StpUtil.logout();
        return ServerResponse.success();
    }

    @GetMapping("/test")
    public ServerResponse test() {
        return ServerResponse.success();
    }
}
