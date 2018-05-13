package com.senchuuhi.iweb.base.model;

import java.io.Serializable;

public class ResponseModel implements Serializable {

    /*** serialVersionUID ***/
    private static final long serialVersionUID = 1636161099193247911L;

    /*** 状态 ***/
    private boolean success = true;

    /*** 返回消息 ***/
    private String message = "";

    /*** 附加的数据 **/
    private Object data = null;

    /*** 当前页数 **/
    private int pageNum = 0;

    /*** 每页大小 **/
    private int pageSize = 0;

    /*** 总数量 **/
    private long totalNum = 0;


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
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

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public long getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }
}
