package com.senchuuhi.iweb.iextend.spider.processor;


import com.senchuuhi.iweb.iextend.spider.monitor.SpiderStatusInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


/**
 * 58同城租房数据抓取
 */
@Component
public class RentHousePriceProcessor implements PageProcessor, SpiderStatusInfo {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    private Site site = Site.me()
            .setRetryTimes(3)
            .setSleepTime(100)
            .setTimeOut(3000)
            .setCharset("utf-8");

    // 0 - 城市选择页面 http://www.58.com/changecity.html?catepath=chuzu&catename=出租
    private final int CITY_CHOOSE_PAGE = 0;

    // 1 - 租房列表页面 http://hf.58.com/chuzu/?PGTID=0d000000-0000-01e2-ea56-b7f5ac2587ba&ClickID=1
    private final int LIST_PAGE = 1;

    // 2 - 租房详情页面
    private final int DETAILS_PAGE = 2;

    // 2 - 限制页面
    private final int LIMITED_PAGE = 3;

    // HavenMoviesProcessor
    public void process(Page page) {

        int type = getPageType(page);
        try {
            TimeUnit.SECONDS.sleep(3 + (long)Math.random());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (type == CITY_CHOOSE_PAGE) {
            log.info(page.getUrl().toString() + "城市选择页面");
            processCitiesPage(page);
        } else if (type == LIST_PAGE)  {
            log.info(page.getUrl().toString() + " 是LIST_PAGE");

            processListPage(page);
        } else if (LIMITED_PAGE == type){

            try {
                log.info(page.getUrl().toString() + " 是限制页面，等待100s");
                TimeUnit.SECONDS.sleep(100);
                page.addTargetRequest(page.getUrl().toString() + "?nox=" + Math.random());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } else{
            log.info(page.getUrl().toString() + " 是DETAILS_PAGE");
            processDetails(page);
        }

    }

    public Site getSite() {
        return site;
    }

    // 城市选择页数据处理
    public void processCitiesPage(Page page) {

        //Map cityMap = new LinkedHashMap<String, String>();
        // 用来保存网址的
        List<String> webList = new ArrayList<>();
        int i = 0;
        Html html = page.getHtml();
        List<String> list = html.xpath("//script/html()").all();
        for (String temp : list) {
            if (temp != null && !temp.trim().equals("") && temp.indexOf("cityList") != -1) {

                String shengfenTemp = temp.substring(temp.indexOf("cityList = ") + 11);
                String[] shengfens = shengfenTemp.split("\n");
                for (String shengfen : shengfens) {
                    if (shengfen.length() > 12) {
                        String citys = shengfen.substring(12, shengfen.indexOf("}"));

                        for (String city : citys.split(",")) {
                            city = city.replace("\"", "");
                            // 只看国内的
                            if (city.indexOf("|") != -1) {
                                String cityName = city.substring(0, city.indexOf(":"));
                                String cityCode = city.substring(city.indexOf(":") + 1, city.indexOf("|"));
                                String cityWeb = "http://" + cityCode +".58.com/chuzu/?no=" + (i++) + "&PGTID=0d3090a7-0034-5c1c-91b8-7d7bf84e53a0&ClickID=3";
                                //cityMap.put(cityName,cityCode );
                                webList.add(cityWeb);
                            }
                        }
                    }
                }
            }

        }

        if (webList.size() > 0 ) {
            page.addTargetRequests(webList);
        }

    }

    // 列表选择页数据处理
    public void processListPage(Page page) {
        Html html = page.getHtml();
        //des
        List<Selectable> list = html.xpath("//ul[@class='listUl']/li").nodes();

        for (Selectable sel : list) {
            String placeName = sel.xpath("//h2/a/text()").toString();
            String placeUrl = sel.xpath("//a/@href").toString();
            String money = sel.xpath("//div[@class='money']/b/text()").toString();
            String className = sel.xpath("//div[@class='pager']/html()").toString();
            if (className != null && !className.trim().equals("")) {
                placeUrl = sel.xpath("//div[@class='pager']//a[@class='next']/@href").toString();
                System.out.println("下一页 | " + placeUrl);
                page.addTargetRequest(placeUrl);
                // 防止页面被限制
                page.addTargetRequest("http://img.58cdn.com.cn/ui6/topbar/58.png?terminal=pc&test=" + Math.random());
            } else {
                System.out.println(placeName + " | " + placeUrl + " | " + money);
            }

        }

    }

    // 详情页处理
    public void processDetails(Page page) {

    }

    // 分析当前抓取的页面类型
    public int getPageType(Page page) {

        Html html = page.getHtml();

        List<String> list = html.xpath("//div[@id='selector-city-result']/html()").all();
        List<String> list2 = html.xpath("//ul[@class='listUl']/html()").all();
        List<String> list3 = html.xpath("//div[@class='code_img']/html()").all();

        if (list != null && list.size() > 0) {
            return CITY_CHOOSE_PAGE;
        } else if (list2 != null && list2.size() > 0) {
            return LIST_PAGE;
        } else if (list3 != null && list3.size() > 0){
            return LIMITED_PAGE;
        }
        return DETAILS_PAGE;

    }

    // 判断该数据是否已经抓取过了
    public Boolean isExist() {
        return false;
    }


}
