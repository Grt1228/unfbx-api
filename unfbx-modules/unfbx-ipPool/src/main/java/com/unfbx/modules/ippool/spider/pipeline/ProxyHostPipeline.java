package com.unfbx.modules.ippool.spider.pipeline;

import com.unfbx.modules.ippool.entity.ProxyHost;
import com.unfbx.modules.ippool.service.ProxyHostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.List;

/**
 * 描述：处理爬取的代理数据，保存到数据库
 *
 * @author grt
 * @date 2022-05-22
 */
@Service
public class ProxyHostPipeline implements Pipeline {
    @Autowired
    private ProxyHostService proxyHostService;

    @Override
    public void process(ResultItems resultItems, Task task) {
        List<ProxyHost> proxyHosts = resultItems.get("proxyHosts");
        proxyHostService.batchAdd(proxyHosts);
    }
}
