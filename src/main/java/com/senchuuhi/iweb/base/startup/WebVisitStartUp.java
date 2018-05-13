package com.senchuuhi.iweb.base.startup;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 每次页面被访问时调用
 */
@Component
public class WebVisitStartUp {

    private WebVisitStartUp() {

    }

    /**
     * 当用户正常发起请求时将会调用该方法, 包含所有请求
     * @param request
     * @param response
     */
    public void  doSomeThing(HttpServletRequest request, HttpServletResponse response) {
        String basePath = request.getContextPath();
        request.setAttribute("basePath", basePath);
    }

}
