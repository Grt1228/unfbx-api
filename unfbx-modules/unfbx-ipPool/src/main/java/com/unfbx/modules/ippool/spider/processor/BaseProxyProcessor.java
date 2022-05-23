package com.unfbx.modules.ippool.spider.processor;

import com.unfbx.modules.ippool.spider.pipeline.ProxyHostPipeline;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * 描述：
 *
 * @author grt
 * @date 2022-05-22
 */
public abstract  class BaseProxyProcessor implements PageProcessor {

    protected Site site = Site.me().setRetryTimes(3).setSleepTime(100);
    protected static final String PROXY_HOSTS = "proxyHosts";

    @Override
    public void process(Page page) {
    }

    @Override
    public Site getSite() {
        return site;
    }

    /**
     * 带URL参数的抽象方法
     * @param urls
     */
    public abstract void start(ProxyHostPipeline pipeline, String... urls);

    /**
     *内置URL参数的抽象方法
     */
    public abstract void start(ProxyHostPipeline pipeline);

    protected static void run(BaseProxyProcessor proxyProcessor,ProxyHostPipeline pipeline, String... urls) {
        Spider.create(proxyProcessor)
            .addUrl(urls)
            .addPipeline(pipeline)
            //开启5个线程抓取
            .thread(1)
            //启动爬虫
            .run();
    }
}
