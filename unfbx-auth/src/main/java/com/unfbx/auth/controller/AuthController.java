package com.unfbx.auth.controller;

import cn.dev33.satoken.stp.SaLoginConfig;
import cn.dev33.satoken.stp.StpUtil;
import com.unfbx.common.core.domain.ServerResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("")
public class AuthController {
    // 测试登录
    @PostMapping("/login")
    public ServerResponse login() {
        StpUtil.login(10001, SaLoginConfig
                .setExtra("name", "旺旺")
                .setExtra("age", 18)
                .setExtra("role", Arrays.asList("管理员")));
        return ServerResponse.success(StpUtil.getTokenInfo().getTokenValue());
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
