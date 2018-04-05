package com.senchuuhi.iweb.functions.article.service;

import com.senchuuhi.iweb.auto.entity.ResArticle;
import com.senchuuhi.iweb.functions.article.constants.ArticleConstants;

import java.util.List;

public interface ResArticleService extends ArticleConstants {


    /**
     * 获取文章
     *
     * @param pageNum  pageNum
     * @param pageSize pageSize
     * @return
     */
    public List<ResArticle> getArticles(Integer pageNum, Integer pageSize, String keyword, String type);

    /**
     * 获取文章
     *
     * @return
     */
    public ResArticle getArticlesInfo(Integer id);

}
