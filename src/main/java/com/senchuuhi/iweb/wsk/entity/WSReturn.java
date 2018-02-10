package com.senchuuhi.iweb.wsk.entity;

import java.io.Serializable;

public class WSReturn implements Serializable {

    private static final long serialVersionUID = -6246309339639014867L;

    private String command;

    private String orginCommand;

    private boolean status = true;

    private Object data;

    private String message;

    private long total;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getOrginCommand() {
        return orginCommand;
    }

    public void setOrginCommand(String orginCommand) {
        this.orginCommand = orginCommand;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
