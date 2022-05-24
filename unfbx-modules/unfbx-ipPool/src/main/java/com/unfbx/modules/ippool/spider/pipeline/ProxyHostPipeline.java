package com.unfbx.modules.ippool.spider.pipeline;

import com.unfbx.modules.ippool.entity.ProxyHost;
import com.unfbx.modules.ippool.service.ProxyHostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述：处理爬取的代理数据，保存到数据库
 *
 * @author grt
 * @date 2022-05-22
 */
@Component
public class ProxyHostPipeline implements Pipeline {
    @Autowired
    private ProxyHostService proxyHostService;

    @Override
    public void process(ResultItems resultItems, Task task) {
        List<ProxyHost> proxyHosts = resultItems.get("proxyHosts");
        List<ProxyHost> res = new ArrayList<>();
        //校验是否有效的ip
        proxyHosts.forEach(e -> {
            if(isValid(e)){
                res.add(e);
            }
        });
        proxyHostService.batchAdd(res);
    }

    /**
     * 检测ip是否有效
     *
     * @param proxyHost
     * @return
     */
    public static boolean isValid(ProxyHost proxyHost) {
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost.getIp(), Integer.valueOf(proxyHost.getPort())));
        try {
            URLConnection httpCon = new URL("https://www.baidu.com/").openConnection(proxy);
            httpCon.setConnectTimeout(5000);
            httpCon.setReadTimeout(5000);
            int code = ((HttpURLConnection) httpCon).getResponseCode();
            System.out.println(code);
            return code == 200;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
