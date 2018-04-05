package com.senchuuhi.iweb.functions.article.service;


import com.senchuuhi.iweb.wsk.entity.WSReturn;

public interface ResInfoService {


    /**
     * 获取SS信息
     *
     * @param pageNum  pageNum
     * @param pageSize pageSize
     * @return
     */
    public WSReturn getInfo(Integer pageNum, Integer pageSize, String keyword, String type);

    /**
     * 获取SS信息
     *
     * @return
     */
    public WSReturn getInfoDetail(Integer id);
}
