package com.unfbx.modules.ippool.spider.processor;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;

/**
 * 描述：
 *
 * @author grt
 * @date 2022-05-20
 */
public class SixSixProxyProcessor implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);


    @Override
    public void process(Page page) {
        Selectable tbody = page.getHtml().xpath("/html/body/div[4]/div/div/div/div[2]/div/table/tbody");
        Selectable trs = tbody.$("tr");
        List<Selectable> nodes = trs.nodes();
        nodes.remove(0);
        nodes.forEach(e -> {
            List<Selectable> tds = e.$("td").nodes();
            System.out.println(tds.get(0).$("td", "text"));
            System.out.println(tds.get(1).$("td", "text"));
            System.out.println(tds.get(2).$("td", "text"));
            System.out.println(tds.get(3).$("td", "text"));
            System.out.println(tds.get(4).$("td", "text"));
        });
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {

        Spider.create(new SixSixProxyProcessor())
                //从"https://github.com/code4craft"开始抓
                .addUrl("http://www.66ip.cn/areaindex_2/1.html", "http://www.66ip.cn/areaindex_1/1.html")
                //开启5个线程抓取
                .thread(1)
                //启动爬虫
                .run();
    }
}
