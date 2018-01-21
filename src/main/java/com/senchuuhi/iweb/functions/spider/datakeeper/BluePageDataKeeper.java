package com.senchuuhi.iweb.functions.spider.datakeeper;

import com.senchuuhi.iweb.auto.dao.ResInfoMapper;
import com.senchuuhi.iweb.auto.entity.ResInfoExample;
import com.senchuuhi.iweb.functions.spider.processor.BluePageProcessor;
import com.senchuuhi.iweb.auto.entity.ResInfo;
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
public class BluePageDataKeeper implements Pipeline {

    private Logger log = Logger.getLogger(this.getClass());


    @Autowired
    private ResInfoMapper mapper;

    public void doInsert(ResInfo resInfo) {
        resInfo.setDelFlag("0");
        mapper.insert(resInfo);
        log.info("插入数据");
    }

    public List<ResInfo> getTotalInfo() {
        return mapper.selectByExample(null);
    }

    // 判断结果是否已经存在
    public boolean isExist(String title) {

        ResInfoExample example = new ResInfoExample();
        example.createCriteria()
                .andTitleEqualTo(title);
        long num = this.mapper.countByExample(example);
        if (num > 0) {
            return true;
        }
        return false;
    }

    public void process(ResultItems resultItems, Task task) {

        List<ResInfo> list = resultItems.get(BluePageProcessor.PAGE_RESULT_KEY);
        if (list != null && list.size() > 0) {
            for (ResInfo info : list) {
                doInsert(info);
            }
        }

    }
}
