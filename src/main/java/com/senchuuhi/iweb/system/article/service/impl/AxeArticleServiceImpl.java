package com.senchuuhi.iweb.system.article.service.impl;

import com.github.pagehelper.PageHelper;
import com.senchuuhi.iweb.auto.dao.AxeArticleMapper;
import com.senchuuhi.iweb.auto.dao.ResArticleMapper;
import com.senchuuhi.iweb.auto.entity.AxeArticle;
import com.senchuuhi.iweb.auto.entity.AxeArticleExample;
import com.senchuuhi.iweb.base.model.ResponseModel;
import com.senchuuhi.iweb.system.article.service.AxeArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 文章阅读处理类
 */
@Service
public class AxeArticleServiceImpl implements AxeArticleService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ResArticleMapper resArticleMapper;

    @Autowired
    private AxeArticleMapper axeArticleMapper;

    @Override
    public ResponseModel getArticlesList(Integer pageNum, Integer pageSize) {
        ResponseModel rm = new ResponseModel();

        if (pageNum == null || pageNum <= 0 || pageSize == null || pageSize <= 0) {
            pageNum = 1;
            pageSize = 10;
        }
        // 创建查询条件
        AxeArticleExample axeArticleExample = new AxeArticleExample();
        AxeArticleExample.Criteria criteria = axeArticleExample.createCriteria();
        criteria.andDeleteFlagEqualTo((short)0);
        long number = this.axeArticleMapper.countByExample(axeArticleExample);
        // 添加分页参数
        PageHelper.startPage(pageNum, pageSize);
        List<AxeArticle> result = this.axeArticleMapper.selectByExample(axeArticleExample);
        rm.setData(result);
        return rm;
    }

    @Override
    public ResponseModel getArticlesInfoById(Integer id) {
        ResponseModel rm = new ResponseModel();
        AxeArticle axeArticle = null;
        if (id != null) {
            axeArticle = this.axeArticleMapper.selectByPrimaryKey(id);
        }
        rm.setData(axeArticle);
        return rm;
    }
}
