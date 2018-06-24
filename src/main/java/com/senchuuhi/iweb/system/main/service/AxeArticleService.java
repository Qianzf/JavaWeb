package com.senchuuhi.iweb.system.main.service;

import com.senchuuhi.iweb.base.model.ResponseModel;

public interface AxeArticleService {


    /**
     * 获取文章
     *
     * @param pageNum  pageNum
     * @param pageSize pageSize
     * @return
     */
    public ResponseModel getArticlesList(Integer pageNum, Integer pageSize, String keyword);

    /**
     * 获取文章
     *
     * @return
     */
    public ResponseModel getArticlesInfoById(Integer id);

}
