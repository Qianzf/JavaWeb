package com.senchuuhi.iweb.system.main.service.impl;

import com.github.pagehelper.PageHelper;
import com.senchuuhi.iweb.auto.dao.AxeArticleMapper;
import com.senchuuhi.iweb.auto.dao.ResArticleMapper;
import com.senchuuhi.iweb.auto.entity.AxeArticle;
import com.senchuuhi.iweb.auto.entity.AxeArticleExample;
import com.senchuuhi.iweb.base.model.ResponseModel;
import com.senchuuhi.iweb.base.utils.TextProcessUtils;
import com.senchuuhi.iweb.system.main.form.ArticleForm;
import com.senchuuhi.iweb.system.main.service.AxeArticleService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public ResponseModel getArticlesList(Integer pageNum, Integer pageSize, String keyword) {
        ResponseModel rm = new ResponseModel();

        if (pageNum == null || pageNum <= 0 || pageSize == null || pageSize <= 0) {
            pageNum = 1;
            pageSize = 10;
        }
        // 创建查询条件
        AxeArticleExample axeArticleExample = new AxeArticleExample();
        AxeArticleExample.Criteria criteria = axeArticleExample.createCriteria();
        criteria.andDeleteFlagEqualTo((short)0);
        if (StringUtils.isNotEmpty(keyword.trim())) {
            criteria.andArticleNameLike("%" + keyword + "%");
        }
        long number = this.axeArticleMapper.countByExample(axeArticleExample);
        // 添加分页参数
        PageHelper.startPage(pageNum, pageSize);
        // 查询数据
        List<AxeArticle> result = this.axeArticleMapper.selectByExample(axeArticleExample);
        // 设置返回参数
        rm.setData(getFormFromEntity(result));
        rm.setTotalNum(number);
        rm.setPageNum(pageNum);
        rm.setPageSize(pageSize);
        rm.setSuccess(true);
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

    private List<ArticleForm> getFormFromEntity(List<AxeArticle> result) {

        List<ArticleForm> articleFormList = new ArrayList<>();

        for (AxeArticle axeArticle : result) {
            ArticleForm form = new ArticleForm();
            BeanUtils.copyProperties(axeArticle, form);
            setDesc(form);
            articleFormList.add(form);
        }
        return articleFormList;
    }

    // 设置文章简介
    private void setDesc(ArticleForm form) {
        if (form == null) {
            return;
        }
        form.setArticleDesc(TextProcessUtils.parseHtml(form.getArticleContent(), 200));
        form.setArticleContent("");
    }

}
