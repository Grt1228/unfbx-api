package com.unfbx.modules.job.handler;

import com.unfbx.remote.ippool.RemoteIpPoolService;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 描述：
 *
 * @author grt
 * @date 2022-05-25
 */
@Component
@Slf4j
public class ProxyHostHandler {

    @Autowired
    private RemoteIpPoolService ipPoolService;

    @XxlJob("proxyHostHandler")
    public void run(){
        log.info("开始执行ip代理池更新job，时间：{}~~~~~", LocalDateTime.now());
        ipPoolService.refreshPool();
        System.out.println("ProxyHostHandler run");
        log.info("执行ip代理池更新job结束，时间：{}~~~~~", LocalDateTime.now());
    }
}
