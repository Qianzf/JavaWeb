package com.senchuuhi.iweb.functions.install.service;

/**
 * SQL 状态查询以及初始化服务
 */
public interface InstallSQLService {

    /**
     * 数据库是否存在
     * @return
     */
    public boolean isSqlExist();

    /**
     * 数据库是否可以连接
     * @return
     */
    public boolean isSqlConnected();

    /**
     * 数据库是否已被初始化
     * @return
     */
    public boolean isSqlInited();

    /**
     * 初始化数据库
     * @param isOverride true:强制覆盖原有数据
     * @return
     */
    public boolean initSql(boolean isOverride);
}
