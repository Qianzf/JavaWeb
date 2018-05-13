package com.senchuuhi.iweb.system.article.service;

import com.senchuuhi.iweb.auto.entity.AxeArticle;
import com.senchuuhi.iweb.auto.entity.ResArticle;
import com.senchuuhi.iweb.base.model.ResponseModel;
import com.senchuuhi.iweb.system.article.constants.ArticleConstants;

import java.util.List;

public interface AxeArticleService extends ArticleConstants {


    /**
     * 获取文章
     *
     * @param pageNum  pageNum
     * @param pageSize pageSize
     * @return
     */
    public ResponseModel getArticlesList(Integer pageNum, Integer pageSize);

    /**
     * 获取文章
     *
     * @return
     */
    public ResponseModel getArticlesInfoById(Integer id);

}
