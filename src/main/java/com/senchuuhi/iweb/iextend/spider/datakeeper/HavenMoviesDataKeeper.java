package com.senchuuhi.iweb.iextend.spider.datakeeper;

import com.senchuuhi.iweb.auto.dao.ResInfoMapper;
import com.senchuuhi.iweb.auto.entity.ResInfo;
import com.senchuuhi.iweb.auto.entity.ResInfoExample;
import com.senchuuhi.iweb.iextend.spider.processor.BluePageProcessor;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.List;

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
