package com.senchuuhi.iweb.base.model;

import java.io.Serializable;
import java.util.Map;

public class RequestModel implements Serializable {

    /*** serialVersionUID ***/
    private static final long serialVersionUID = 1636161099193247911L;

    /*** 状态 ***/
    private boolean status = true;

    /*** 请求指令 ***/
    private String command = "";

    /*** 请求参数 ***/
    private Map<String, String> query = null;

    /*** 附加的数据 **/
    private Object data = null;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public Map<String, String> getQuery() {
        return query;
    }

    public void setQuery(Map<String, String> query) {
        this.query = query;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
