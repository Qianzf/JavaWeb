package com.senchuuhi.iweb.iextend.spider.task;

import com.senchuuhi.iweb.iextend.spider.datakeeper.RentHousePriceDataKeeper;
import com.senchuuhi.iweb.iextend.spider.processor.RentHousePriceProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.scheduler.QueueScheduler;
import us.codecraft.webmagic.scheduler.component.HashSetDuplicateRemover;

@Component
public class RentHouseTask {

    public static final String WEB_PREFIX = "https://www.347abc.com";

    private static Spider spider = null;

    @Autowired
    private RentHousePriceProcessor rentHousePriceProcessor;

    @Autowired
    private RentHousePriceDataKeeper rentHousePriceDataKeeper;

    // 页面调度器
    private QueueScheduler queueScheduler = new QueueScheduler();

    public QueueScheduler start() {


        //bluePageProcessor.setReadyInfo(bluePageDataKeeper.getTotalInfo());

        spider = Spider.create(rentHousePriceProcessor).addPipeline(rentHousePriceDataKeeper)
                .thread(1);
        //spider.addUrl("http://www.58.com/changecity.html?catepath=chuzu&catename=出租");
        spider.addUrl("http://hf.58.com/chuzu/?PGTID=0d000000-0000-01e2-ea56-b7f5ac2587ba&ClickID=1");
        //spider.addUrl("http://hf.58.com/hezu/33165050310451x.shtml");
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
