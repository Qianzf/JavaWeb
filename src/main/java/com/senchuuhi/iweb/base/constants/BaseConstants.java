package com.senchuuhi.iweb.base.constants;

/**
 * 系统基础常量定义
 */
public interface BaseConstants {

    /*****  用户session标志 *****/
    public static final String SESSION_USER = "SESSION_USER";

    /********* 角色：管理员 *********/
    public static final String ROLE_ADMIN = "admin";

    /********* 角色：普通用户 *********/
    public static final String ROLE_USER = "user";

    /****** 禁止访问页面 ********/
    public static final String URL_LOGIN = "/static/pages/permission_deny.html";

}
