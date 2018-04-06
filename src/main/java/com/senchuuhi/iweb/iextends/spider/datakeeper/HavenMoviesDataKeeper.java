package com.senchuuhi.iweb.iextends.spider.datakeeper;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

/**
 * bluepage的数据持久化工具.
 */
@Repository
public class HavenMoviesDataKeeper implements Pipeline {

    private Logger log = Logger.getLogger(this.getClass());

    public void process(ResultItems resultItems, Task task) {

       /* List<ResInfo> list = resultItems.get(BluePageProcessor.PAGE_RESULT_KEY);
        if (list != null && list.size() > 0) {
            for (ResInfo info : list) {
                doInsert(info);
            }
        }*/

    }
}
