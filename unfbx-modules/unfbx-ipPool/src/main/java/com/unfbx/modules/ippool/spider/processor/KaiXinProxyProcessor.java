package com.unfbx.modules.ippool.spider.processor;

import com.unfbx.modules.ippool.entity.ProxyHost;
import com.unfbx.modules.ippool.spider.pipeline.ProxyHostPipeline;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.selector.Selectable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述：开心代理
 *
 * @author grt
 * @date 2022-05-24
 */
public class KaiXinProxyProcessor extends BaseProxyProcessor {

    @Override
    public void process(Page page) {
        Selectable tbody = page.getHtml().$("tbody");
        Selectable trs = tbody.$("tr");
        List<Selectable> nodes = trs.nodes();
        List<ProxyHost> proxyHosts = new ArrayList<>();
        nodes.forEach(e -> {
            ProxyHost proxyHost = new ProxyHost();
            List<Selectable> tds = e.$("td").nodes();
            proxyHost.setIp(tds.get(0).$("td", "text").get());
            proxyHost.setPort(tds.get(1).$("td", "text").get());
            proxyHost.setType(ProxyHost.Type.HTTP.code());
            proxyHost.setArea(tds.get(5).$("td", "text").get());
            proxyHost.setVerifyTime(LocalDateTime.now());
            proxyHost.setAnonymous(ProxyHost.Anonymous.HIGH.code());
            proxyHosts.add(proxyHost);
        });
        page.putField(PROXY_HOSTS, proxyHosts);
    }

    @Override
    public Site getSite() {
        return super.site;
    }


    public void start(ProxyHostPipeline pipeline, String... urls) {
        run(new KaiXinProxyProcessor(), pipeline, urls);
    }

    public void start(ProxyHostPipeline pipeline) {
        run(new KaiXinProxyProcessor(), pipeline, "http://www.kxdaili.com/dailiip/1/1.html");
    }

    public static void main(String[] args) {
        Spider.create(new KaiXinProxyProcessor())
                .addUrl("http://www.kxdaili.com/dailiip/1/1.html")
                //开启5个线程抓取
                .thread(1)
                //启动爬虫
                .run();
    }

}
