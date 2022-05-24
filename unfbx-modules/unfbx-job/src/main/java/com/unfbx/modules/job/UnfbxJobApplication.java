package com.unfbx.modules.job;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UnfbxJobApplication {

    public static void main(String[] args) {
        SpringApplication.run(UnfbxJobApplication.class, args);
    }

}
