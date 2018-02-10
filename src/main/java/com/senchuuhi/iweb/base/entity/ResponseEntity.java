package com.senchuuhi.iweb.base.entity;

import java.io.Serializable;
import java.util.Map;

public class ResponseEntity implements Serializable {

    /*** serialVersionUID ***/
    private static final long serialVersionUID = 1636161099193247911L;

    /*** 状态 ***/
    private boolean status = true;

    /*** 返回消息 ***/
    private String message = "";

    /*** 附加的数据 **/
    private Object data = null;

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
