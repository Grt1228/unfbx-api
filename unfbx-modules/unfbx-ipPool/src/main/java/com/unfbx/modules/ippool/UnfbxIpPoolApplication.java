package com.unfbx.modules.ippool;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.unfbx.**.mapper")
public class UnfbxIpPoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(UnfbxIpPoolApplication.class, args);
    }

}
