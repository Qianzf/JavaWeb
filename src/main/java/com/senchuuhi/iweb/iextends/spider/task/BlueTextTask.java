package com.senchuuhi.iweb.iextends.spider.task;


import com.senchuuhi.iweb.iextends.spider.datakeeper.BlueTextDataKeeper;
import com.senchuuhi.iweb.iextends.spider.processor.BlueTextProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.scheduler.QueueScheduler;
import us.codecraft.webmagic.scheduler.component.HashSetDuplicateRemover;

import java.util.ArrayList;
import java.util.List;

@Component
public class BlueTextTask {

    public static final String WEB_PREFIX = "https://www.347abc.com";

    private static List<Spider> spiders = new ArrayList<Spider>();

    @Autowired
    private BlueTextProcessor blueTextProcessor;

    @Autowired
    private BlueTextDataKeeper blueTextDataKeeper;

    // 页面调度器
    private QueueScheduler queueScheduler = new QueueScheduler();

    public void start() {
        // 110 62 86 101 89 93 109 94 95 96 128 98 127 123 110 114

        blueTextProcessor.setReadyInfo(blueTextDataKeeper.getTotalInfo());
        Spider ss = Spider.create(blueTextProcessor)
                .addUrl(WEB_PREFIX + "/Html/84/index-104.html")
                .addPipeline(blueTextDataKeeper)
                .thread(5);
        ss.setScheduler(queueScheduler.setDuplicateRemover(new HashSetDuplicateRemover()));
        ss.start();
        spiders.add(ss);
    }

    public static void stop() {
        for (Spider spider : spiders) {
            spider.stop();
        }
    }

}
