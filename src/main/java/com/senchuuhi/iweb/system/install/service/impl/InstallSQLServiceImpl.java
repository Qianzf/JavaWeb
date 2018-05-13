package com.senchuuhi.iweb.system.install.service.impl;

import com.senchuuhi.iweb.base.service.BaseService;
import com.senchuuhi.iweb.system.install.service.InstallSQLService;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class InstallSQLServiceImpl extends BaseService implements InstallSQLService {

    @Override
    public boolean isSqlConnected() {
        Connection conn = null;
        try {
            conn = super.getDao().getConfiguration().getEnvironment().getDataSource().getConnection();
            if(conn.isValid(3)) {
                // 数据库可以连接
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<String> getTableNames() {
        List<String> list = new ArrayList<String>();
        Connection conn = null;
        try {
            conn = super.getDao().getConfiguration().getEnvironment().getDataSource().getConnection();
            if (conn.isValid(1)) {
                // 获取所有的表的名字
                ResultSet rs = conn.getMetaData().getTables(conn.getCatalog(), "root", null, new String[]{"TABLE"});
                while(rs.next()) {
                    list.add(rs.getString("TABLE_NAME"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int initSql(boolean isOverride, boolean ignoreExistTables) {
        try {
            if (!ignoreExistTables && this.getTableNames().size() > 0) {
                return 1;
            }
            // 尝试创建table
            if (isOverride) {
                // drop所有的tables
                super.getDao().update("installSqlMapper.dropTables");
            }
            super.getDao().update("installSqlMapper.createTables");
            return 0;
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            if (e.getMessage().indexOf("already exists") != -1) {
                return -1;
            }
        }
        return -2;
    }
}
