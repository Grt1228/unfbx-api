package com.unfbx.modules.job.handler;

import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 描述：
 *
 * @author grt
 * @date 2022-05-25
 */
@Component
@Slf4j
public class ProxyHostHandler {

    @XxlJob("proxyHostHandler")
    public void run(){
        System.out.println("ProxyHostHandler run");
    }
}
