package com.senchuuhi.iweb.base.entity;

import java.io.Serializable;
import java.util.Map;

public class RequestEntity implements Serializable {

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




}
