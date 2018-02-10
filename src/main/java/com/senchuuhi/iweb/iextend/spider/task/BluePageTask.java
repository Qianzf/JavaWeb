package com.senchuuhi.iweb.iextend.spider.task;

import com.senchuuhi.iweb.iextend.spider.datakeeper.BluePageDataKeeper;
import com.senchuuhi.iweb.iextend.spider.processor.BluePageProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.scheduler.QueueScheduler;
import us.codecraft.webmagic.scheduler.component.HashSetDuplicateRemover;

@Component
public class BluePageTask {

    public static final String WEB_PREFIX = "https://www.347abc.com";

    private static Spider spider = null;

    @Autowired
    private BluePageProcessor bluePageProcessor;

    @Autowired
    private BluePageDataKeeper bluePageDataKeeper;

    // 页面调度器
    private QueueScheduler queueScheduler = new QueueScheduler();

    public QueueScheduler start() {
        // 110 62 86 101 89 93 109 94 95 96 128 98 127 123 110 114
        int[] num = {100, 60, 62, 86, 101, 89, 93, 109, 94, 95, 96, 128, 98, 127, 123, 110, 114};

        bluePageProcessor.setReadyInfo(bluePageDataKeeper.getTotalInfo());

        spider = Spider.create(bluePageProcessor).addPipeline(bluePageDataKeeper)
                .thread(5);
        for (int tmp : num) {
            spider.addUrl(WEB_PREFIX + "/Html/" + tmp + "/");
        }
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
