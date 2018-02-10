package com.senchuuhi.iweb.iextend.spider.datakeeper;

import com.senchuuhi.iweb.auto.dao.ResArticleMapper;
import com.senchuuhi.iweb.auto.entity.ResArticle;
import com.senchuuhi.iweb.iextend.spider.processor.BluePageProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.List;

/**
 * bluepage的数据持久化工具.
 */
@Component
public class BlueTextDataKeeper implements Pipeline {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ResArticleMapper resArticleMapper;

    public synchronized void doInsert(ResArticle info) {
        info.setDelFlag("0");
        resArticleMapper.insert(info);
    }

    public List<ResArticle> getTotalInfo() {
        return resArticleMapper.selectByExample(null);
    }


    public void process(ResultItems resultItems, Task task) {

        ResArticle data = resultItems.get(BluePageProcessor.PAGE_RESULT_KEY);
        doInsert(data);
    }
}
