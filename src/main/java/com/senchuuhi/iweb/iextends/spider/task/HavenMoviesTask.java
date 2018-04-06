package com.senchuuhi.iweb.iextends.spider.task;

import com.senchuuhi.iweb.iextends.spider.datakeeper.HavenMoviesDataKeeper;
import com.senchuuhi.iweb.iextends.spider.processor.HavenMoviesProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.scheduler.QueueScheduler;
import us.codecraft.webmagic.scheduler.component.HashSetDuplicateRemover;

@Component
public class HavenMoviesTask {

    public static final String WEB_PREFIX = "https://www.347abc.com";

    private static Spider spider = null;

    @Autowired
    private HavenMoviesProcessor havenMoviesProcessor;

    @Autowired
    private HavenMoviesDataKeeper havenMoviesDataKeeper;

    // 页面调度器
    private QueueScheduler queueScheduler = new QueueScheduler();

    public QueueScheduler start() {


        //bluePageProcessor.setReadyInfo(bluePageDataKeeper.getTotalInfo());

        spider = Spider.create(havenMoviesProcessor).addPipeline(havenMoviesDataKeeper)
                .thread(5);
        spider.addUrl("http://www.dytt8.net/html/gndy/china/index.html");
        spider.addUrl("http://www.dytt8.net/html/gndy/dyzz/20180220/56345.html");
        spider.setScheduler(queueScheduler
                .setDuplicateRemover(new HashSetDuplicateRemover()) //10000000是估计的页面数量
        );
        // 开启多线程
        spider.start();
        // 返回页面调度器
        return queueScheduler;
    }

    public static void stop() {
        if (spider != null) {
            spider.stop();
        }
    }

}
