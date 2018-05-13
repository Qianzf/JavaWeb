package com.senchuuhi.iweb.system.install.service;

import java.util.List;

/**
 * SQL 状态查询以及初始化服务
 */
public interface InstallSQLService {


    /**
     * 数据库是否可以连接
     * @return
     */
    public boolean isSqlConnected();

    /**
     * 获取数据库里面所有表的表名
     * @return
     */
    public List<String> getTableNames();

    /**
     * 初始化数据库
     * @param isOverride true:强制覆盖原有数据
     * @param ignoreExistTables true:忽略已有表数据，不要求是个空的数据库
     * @return
     * 1:数据库中已经包含了表数据
     * 0:数据库表创建正确执行完成
     * -1：数据库表已存在，没有完成覆盖
     * -2：创建表过程中发生未知异常错误
     */
    public int initSql(boolean isOverride, boolean ignoreExistTables);
}
