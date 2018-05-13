package com.senchuuhi.iweb.base.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseService {

    @Autowired
    private SqlSession dao;

    public SqlSession getDao() {
        return dao;
    }
}
