package com.senchuuhi.iweb.base.constants;

/**
 * 系统基础常量定义
 */
public interface BaseConstants {

    /******************************************************************************************************************/
    // SESSION相关的常量
    /******************************************************************************************************************/
    /*****  用户session标志 *****/
    public static final String SESSION_USER = "SESSION_USER";


    /******************************************************************************************************************/
    // 角色相关的常量
    /******************************************************************************************************************/
    /********* 角色：管理员 *********/
    public static final String ROLE_ADMIN = "admin";

    /********* 角色：普通用户 *********/
    public static final String ROLE_USER = "user";


    /******************************************************************************************************************/
    // 页面相关的常量
    /******************************************************************************************************************/
    /********* 页面：标题 *********/
    public static final String PAGE_TITLE = "title";

    /********* 页面：默认媒体名称 *********/
    public static final String PAGE_META = "defaultMetaName";

    /********* 页面：默认风格 *********/
    public static final String PAGE_STYLE = "defaultStyleName";

    /********* 页面：默认脚本 *********/
    public static final String PAGE_SCRIPT = "defaultScriptName";

    /********* 页面：默认显示页面 *********/
    public static final String PAGE_NAME = "pageName";


    /******************************************************************************************************************/
    // 路径相关的常量
    /******************************************************************************************************************/
    /****** 禁止访问页面 ********/
    public static final String URL_LOGIN = "/static/pages/permission_deny.html";


    /******************************************************************************************************************/
    // 默认设定的常量
    /******************************************************************************************************************/
    /****** 默认页面标题 ********/
    public static final String DEFAULT_PAGE_TITLE = "AXE";

    /****** 默认媒体 ********/
    public static final String DEFAULT_PAGE_META = "basic_meta";

    /****** 默认风格 ********/
    public static final String DEFAULT_PAGE_STYLE = "basic_style";

    /****** 默认脚本 ********/
    public static final String DEFAULT_PAGE_SCRIPT = "basic_script";

    /****** 默认显示页面 ********/
    public static final String DEFAULT_PAGE_NAME = "index";


}
