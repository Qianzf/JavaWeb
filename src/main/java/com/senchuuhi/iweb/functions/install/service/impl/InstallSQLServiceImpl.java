package com.senchuuhi.iweb.functions.install.service.impl;

import com.senchuuhi.iweb.base.service.BaseService;
import com.senchuuhi.iweb.functions.install.service.InstallSQLService;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Service
public class InstallSQLServiceImpl extends BaseService implements InstallSQLService {


    @Override
    public boolean isSqlExist() {

        return false;
    }

    @Override
    public boolean isSqlConnected() {
        Connection conn = super.getSqlSession().getConnection();

        try {
            conn.isValid(2);
            conn.getMetaData().getSchemas();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean isSqlInited() {
        Connection conn = null;
        try {
            conn = super.getSqlSession().getConfiguration().getEnvironment().getDataSource().getConnection();
            if (conn.isValid(1)) {
                // 获取所有的表的名字
                ResultSet rs = conn.getMetaData().getTables(conn.getCatalog(), "root", null, new String[]{"TABLE"});
                while(rs.next()) {
                    System.out.println(rs.getString("TABLE_NAME"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean initSql(boolean isOverride) {
        return false;
    }
}
