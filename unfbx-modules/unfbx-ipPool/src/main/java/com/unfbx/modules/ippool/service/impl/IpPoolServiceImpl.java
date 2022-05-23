package com.unfbx.modules.ippool.service.impl;

import com.unfbx.modules.ippool.entity.IpOrigin;
import com.unfbx.modules.ippool.service.IpOriginService;
import com.unfbx.modules.ippool.service.IpPoolService;
import com.unfbx.modules.ippool.spider.pipeline.ProxyHostPipeline;
import com.unfbx.modules.ippool.spider.processor.SixSixProxyProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IpPoolServiceImpl implements IpPoolService {
    @Autowired
    private IpOriginService ipOriginService;
    @Autowired
    private ProxyHostPipeline pipeline;

    @Override
    public void refreshPool() {
//        List<IpOrigin> ipOrigins = ipOriginService.queryList();
//        ipOrigins.forEach(e -> {
//
//        });

        SixSixProxyProcessor sixSixProxyProcessor = new SixSixProxyProcessor();
        sixSixProxyProcessor.start(pipeline);
    }
}
