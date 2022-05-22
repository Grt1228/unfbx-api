package com.unfbx.modules.ippool.spider.processor;

import com.unfbx.modules.ippool.entity.ProxyHost;
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
            proxyHost.setArea(tds.get(3).$("td", "text").get());
            proxyHost.setVerifyTime(LocalDateTime.now());
            proxyHosts.add(proxyHost);
        });
        page.putField(PROXY_HOSTS, proxyHosts);
    }

    @Override
    public Site getSite() {
        return super.site;
    }


    public void start(String... urls) {
        run(new SixSixProxyProcessor(), urls);
    }

    public void start() {
        run(new SixSixProxyProcessor(), "http://www.66ip.cn/areaindex_2/1.html", "http://www.66ip.cn/areaindex_1/1.html");
    }

//    public static void main(String[] args) {
//
//        Spider.create(new SixSixProxyProcessor())
//                //从"https://github.com/code4craft"开始抓
//                .addUrl()
//                .addPipeline(new ProxyHostPipeline())
//                //开启5个线程抓取
//                .thread(1)
//                //启动爬虫
//                .run();
//    }
}
