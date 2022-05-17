package com.unfbx.modules.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan("com.unfbx.**.mapper")
@EnableDiscoveryClient
public class UnfbxApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(UnfbxApiApplication.class, args);
    }

}
