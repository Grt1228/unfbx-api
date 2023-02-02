package com.unfbx.auth;

import cn.dev33.satoken.SaManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@Slf4j
@EnableDiscoveryClient
public class UnfbxAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(UnfbxAuthApplication.class, args);
        log.info(">>>>>>>>启动成功：Sa-Token配置如下：" + SaManager.getConfig());
    }

}
