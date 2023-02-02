package com.unfbx.common.web.utils;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfig {


    @Bean
    @ConditionalOnProperty(name = "redis.type",havingValue = "cluster")
    public RedisTemplate redisTemplate(){

    }

    @Bean
    @ConditionalOnProperty(name = "redis.type",havingValue = "standalone")
    public RedisTemplate redisTemplate(){

    }
}
