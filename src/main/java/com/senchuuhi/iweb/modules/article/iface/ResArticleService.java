package com.senchuuhi.iweb.modules.article.iface;

import com.senchuuhi.iweb.auto.entity.ResArticle;
import com.senchuuhi.iweb.modules.article.constants.ArticleConstants;

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
