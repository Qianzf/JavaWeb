package com.senchuuhi.iweb.wsk.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.io.Serializable;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ComReturn implements Serializable {

    //序列化ID
    private static final long serialVersionUID = -5809782578272943999L;

    /**
     * 当前页数
     **/
    private int pageNum = 0;

    /**
     * 每页数量
     **/
    private int pageSize = 0;

    /**
     * 全部数量
     **/
    private int total = 0;

    /**
     * 状态标识
     **/
    private boolean status = true;

    /**
     * 提示信息
     **/
    private String message = "";

    /**
     * 数据
     **/
    private Object data = null;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
