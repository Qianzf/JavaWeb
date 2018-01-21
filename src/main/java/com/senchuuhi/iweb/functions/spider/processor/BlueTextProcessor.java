package com.senchuuhi.iweb.functions.spider.processor;


import com.senchuuhi.iweb.auto.entity.ResArticle;
import com.senchuuhi.iweb.functions.spider.monitor.SpiderStatusInfo;
import com.senchuuhi.iweb.functions.spider.task.BlueTextTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class BlueTextProcessor implements PageProcessor, SpiderStatusInfo {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    private Site site = Site.me()
            .setDomain(BlueTextTask.WEB_PREFIX)
            .setUseGzip(true)
            .setRetryTimes(3)
            .setSleepTime(500)
            .setTimeOut(5000)
            .setRetrySleepTime(1500)
            .setCharset("utf-8");

    private final String URL_LIST = "index|/$";

    public static String PAGE_RESULT_KEY = "result";

    private List<ResArticle> readyInfo = new ArrayList<ResArticle>();

    public List<ResArticle> getReadyInfo() {
        return readyInfo;
    }

    public void setReadyInfo(List<ResArticle> readyInfo) {
        this.readyInfo = readyInfo;
    }

    public void process(Page page) {
        if (page.getUrl().regex(URL_LIST).match()) {
            // 列表页
            Html html = page.getHtml();
            List<String> list = html.xpath("//div[@class='box list channel']/ul/li/").all();
            List<String> urlList = new ArrayList<String>();
            boolean isExist = false;
            for (String web : list) {
                Html tmp = new Html(web);
                String url = BlueTextTask.WEB_PREFIX + tmp.xpath("//a/@href").toString();
                String title = tmp.xpath("//a/text()").toString();
                log.info(url + " | " + title);

                for (ResArticle info : readyInfo) {
                    if (info.getTitle() != null && info.getTitle().equals(title)) {
                        // 数据已经存在
                        isExist = true;
                        break;
                    }
                }
                if (!isExist) {
                    urlList.add(url);
                }
            }
            // 获取下一页信息
            if (!isExist) {
                String nextPage = null;
                if (html.xpath("//a[@class='next pagegbk']/@href").toString() != null) {
                    nextPage = BlueTextTask.WEB_PREFIX + html.xpath("//a[@class='next pagegbk']/@href").toString();
                    urlList.add(nextPage);
                }
            }
            page.addTargetRequests(urlList);
            // 跳过改页
            page.setSkip(true);
        } else {
            // 详情页
            Html html = page.getHtml();

            String title = html.xpath("//div[@class='page_title']/h1/text()").toString();
            String content = html.xpath("//div[@class='content']/font/html()").toString();
            ResArticle reaArticle = new ResArticle();
            reaArticle.setContent(content);
            reaArticle.setTitle(title);
            reaArticle.setCreateTime(new Date());
            reaArticle.setUpdateTime(new Date());
            reaArticle.setAuthor("佚名_245abc");
            reaArticle.setDelFlag("0");
            reaArticle.setSource(page.getUrl().toString());
            page.putField(PAGE_RESULT_KEY, reaArticle);
            //
            log.info(" | 详情页 | " + title);
            // bpDataKeeper.doInsert(ResArticle);
            //log.info(" > " + type + "|" + time + "|" + title + " | " + img + " | " + (urlList.size()==0 ? "无下载链接":urlList.get(0)) );
        }

        //page.addTargetRequests(list);
        //page.putField("author", page.getUrl().regex("https://github\\.com/(\\w+)/.*").toString());
        //page.putField("name", page.getHtml().xpath("//div[@class='box movie_list']/ul/li/a/@href").toString());
        //if (page.getResultItems().get("name")==null){
        //skip this page
        //    page.setSkip(true);
        //}
        //page.putField("readme", page.getHtml().xpath("//div[@id='readme']/tidyText()"));
    }

    public Site getSite() {
        return site;
    }

}
