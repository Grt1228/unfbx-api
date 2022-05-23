package com.unfbx.modules.ippool.spider.processor;

import com.unfbx.modules.ippool.entity.ProxyHost;
import com.unfbx.modules.ippool.spider.pipeline.ProxyHostPipeline;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.selector.Selectable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述：
 *
 * @author grt
 * @date 2022-05-20
 */
public class SixSixProxyProcessor extends BaseProxyProcessor {

    @Override
    public void process(Page page) {
        Selectable tbody = page.getHtml().xpath("/html/body/div[4]/div/div/div/div[2]/div/table/tbody");
        Selectable trs = tbody.$("tr");
        List<Selectable> nodes = trs.nodes();
        nodes.remove(0);
        List<ProxyHost> proxyHosts = new ArrayList<>();
        nodes.forEach(e -> {
            ProxyHost proxyHost = new ProxyHost();
            List<Selectable> tds = e.$("td").nodes();
            proxyHost.setIp(tds.get(0).$("td", "text").get());
            proxyHost.setPort(tds.get(1).$("td", "text").get());
            proxyHost.setType(ProxyHost.Type.HTTP.code());
            proxyHost.setArea(tds.get(2).$("td", "text").get());
            proxyHost.setVerifyTime(LocalDateTime.now());
            proxyHosts.add(proxyHost);
        });
        page.putField(PROXY_HOSTS, proxyHosts);
    }

    @Override
    public Site getSite() {
        return super.site;
    }


    public void start(ProxyHostPipeline pipeline, String... urls) {
        run(new SixSixProxyProcessor(), pipeline, urls);
    }

    public void start(ProxyHostPipeline pipeline) {
        run(new SixSixProxyProcessor(), pipeline, "http://www.66ip.cn/areaindex_2/1.html", "http://www.66ip.cn/areaindex_1/1.html");
    }

}
