package com.senchuuhi.iweb.iextend.spider.processor;


import com.senchuuhi.iweb.iextend.spider.task.BluePageTask;
import com.senchuuhi.iweb.auto.entity.ResInfo;
import com.senchuuhi.iweb.iextend.spider.monitor.SpiderStatusInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class BluePageProcessor implements PageProcessor, SpiderStatusInfo {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    private Site site = Site.me()
            .setRetryTimes(3)
            .setSleepTime(100)
            .setTimeOut(3000)
            .setCharset("utf-8");

    private final String URL_LIST = "index|/$";

    public static String PAGE_RESULT_KEY = "result";

    private List<ResInfo> readyInfo = new ArrayList<ResInfo>();

    public List<ResInfo> getReadyInfo() {
        return readyInfo;
    }

    public void setReadyInfo(List<ResInfo> readyInfo) {
        this.readyInfo = readyInfo;
    }

    public void process(Page page) {
        if (page.getUrl().regex(URL_LIST).match()) {
            // 列表页
            Html html = page.getHtml();
            List<String> list = html.xpath("//div[@class='box movie_list']/ul/li/").all();
            List<String> urlList = new ArrayList<String>();
            boolean isExist = false;
            for (String web : list) {
                Html tmp = new Html(web);
                String url = BluePageTask.WEB_PREFIX + tmp.xpath("//a/@href").toString();
                String pic = tmp.xpath("//img/@src").toString();
                String title = tmp.xpath("//h3/text()").toString();
                //log.info(url);

                for (ResInfo info : readyInfo) {
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
                String next = null;
                if (html.xpath("//a[@class='next pagegbk']/@href").toString() != null) {
                    next = BluePageTask.WEB_PREFIX + html.xpath("//a[@class='next pagegbk']/@href").toString();
                    //log.info(next);
                    urlList.add(next);
                }
            }


            page.addTargetRequests(urlList);
            // 跳过改页
            page.setSkip(true);
        } else {
            // 详情页
            Html html = page.getHtml();
            // 获取下载链接
            List<String> urlList = html.xpath("//ul[@class='downurl']/a/@href").all();
            // 获取介绍详情
            String details = html.xpath("//div[@class='movie_info']/").all().get(0);
            Html tmp = new Html(details);
            String title = tmp.xpath("//h1/text()").toString();
            String img = tmp.xpath("//img/@src").toString();
            String type = tmp.xpath("//dd[4]/span/text()").toString();
            String time = tmp.xpath("//dd[5]/text()").toString();
            time = time.replace("更新時間：", "");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            //log.info(details);
            ResInfo resInfo = new ResInfo();
            resInfo.setTitle(title);
            resInfo.setImage(img);
            resInfo.setType(type);
            resInfo.setSource(page.getUrl().toString());
            try {
                resInfo.setPublishTime(sdf.parse(time));
            } catch (ParseException e) {
                resInfo.setPublishTime(null);
            }
            resInfo.setCreateTime(new Date());
            resInfo.setUrl(urlList.size() == 0 ? "无下载链接" : urlList.get(0));
            List<ResInfo> list = page.getResultItems().get(PAGE_RESULT_KEY);
            // 插入数据到数据库
            if (list == null) {
                list = new ArrayList<ResInfo>();
                page.putField(PAGE_RESULT_KEY, list);
            }
            list.add(resInfo);
        }

    }

    public Site getSite() {
        return site;
    }

}
