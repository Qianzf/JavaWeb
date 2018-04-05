package com.senchuuhi.iweb.functions.article.service.impl;

import com.github.pagehelper.PageHelper;
import com.senchuuhi.iweb.auto.dao.ResArticleMapper;
import com.senchuuhi.iweb.auto.entity.ResArticle;
import com.senchuuhi.iweb.auto.entity.ResArticleExample;
import com.senchuuhi.iweb.functions.article.service.ResArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResArticleServiceImpl implements ResArticleService{

    @Autowired
    private ResArticleMapper resArticleMapper;

    /**
     * 获取文章
     *
     * @param pageNum  pageNum
     * @param pageSize pageSize
     * @return
     */
    public List<ResArticle> getArticles(Integer pageNum, Integer pageSize, String keyword, String type) {
        if (pageNum == null || pageNum <= 0 || pageSize == null || pageSize <= 0) {
            pageNum = 1;
            pageSize = 10;
        }
        PageHelper.startPage(pageNum, pageSize);
        return resArticleMapper.selectByExample(null);
    }

    /**
     * 获取文章
     *
     * @return
     */
    public ResArticle getArticlesInfo(Integer id) {
        ResArticleExample resArticleExample = new ResArticleExample();
        resArticleExample.setOrderByClause("CREATE_TIME DESC");
        resArticleExample.createCriteria().andIdEqualTo(id).andDelFlagEqualTo("0");
        List<ResArticle> list = resArticleMapper.selectByExample(resArticleExample);
        if (list.size() > 0) {
            return list.get(0);
        }
        return new ResArticle();
    }

}
