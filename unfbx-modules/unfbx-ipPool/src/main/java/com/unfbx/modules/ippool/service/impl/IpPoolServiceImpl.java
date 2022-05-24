package com.unfbx.modules.ippool.service.impl;

import com.unfbx.modules.ippool.entity.IpOrigin;
import com.unfbx.modules.ippool.service.IpOriginService;
import com.unfbx.modules.ippool.service.IpPoolService;
import com.unfbx.modules.ippool.spider.pipeline.ProxyHostPipeline;
import com.unfbx.modules.ippool.spider.processor.BaseProxyProcessor;
import com.unfbx.modules.ippool.spider.processor.KaiXinProxyProcessor;
import com.unfbx.modules.ippool.spider.processor.SixSixProxyProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class IpPoolServiceImpl implements IpPoolService {
    @Autowired
    private IpOriginService ipOriginService;
    @Autowired
    private ProxyHostPipeline pipeline;

    @Override
    public void refreshPool() {
        List<IpOrigin> ipOrigins = ipOriginService.queryList();

        ipOrigins.forEach(item -> {
            try {
                Class<?> proxyProcessorClass = Class.forName(item.getFullClass());
                BaseProxyProcessor proxyProcessor = (BaseProxyProcessor) proxyProcessorClass.newInstance();
                proxyProcessor.start(pipeline);
            } catch (ClassNotFoundException e) {
                log.info("代理网站{}：URL{}，对应的全路径类不存在~", item.getName(), item.getUrl());
                return;
            } catch (Exception e) {
                log.info("代理网站{}：URL{}，爬取数据过程发生异常~", item.getName(), item.getUrl());
                return;
            }
        });
//
//        BaseProxyProcessor sixSixProxyProcessor = new SixSixProxyProcessor();
//        BaseProxyProcessor kaiXinProxyProcessor = new KaiXinProxyProcessor();
//        sixSixProxyProcessor.start(pipeline);
//        kaiXinProxyProcessor.start(pipeline);
    }

    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(1,2,3,45,5,6,7,8);
        a.forEach(e -> {
            if(e > 10){
                return;
            }
            System.out.println(e);
        });
    }
}
