package com.senchuuhi.iweb.iextends.spider.processor;


import com.senchuuhi.iweb.iextends.spider.monitor.SpiderStatusInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

import java.util.List;


/**
 * 电影天堂的数据抓取
 */
@Component
public class HavenMoviesProcessor implements PageProcessor, SpiderStatusInfo {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    private Site site = Site.me()
            .setRetryTimes(3)
            .setSleepTime(100)
            .setTimeOut(3000)
            .setCharset("GBK");


    public void process(Page page) {

        if (isListPage(page)) {
            log.info(page.getUrl().toString() + "是列表页面");

        } else {
            log.info(page.getUrl().toString() + "不是列表页面");
        }

    }

    public Site getSite() {
        return site;
    }

    // 列表页数据处理
    public void processMain(Page page) {

    }

    // 详情页处理
    public void processDetails(Page page) {

    }

    // 判断是否是列表页还是详情页
    public boolean isListPage(Page page) {
        Html html = page.getHtml();
        html.smartContent();
        List<String> list = html.xpath("//div[@class='co_content8']//div[@id='Zoom']//span/html()").all();
        if (list == null || list.size() == 0) {
            return true;
        } else {
            System.out.println(list.get(0));
        }
        return false;
    }

    // 判断该数据是否已经抓取过了
    public Boolean isExist() {
        return false;
    }


}
