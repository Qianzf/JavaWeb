package com.senchuuhi.iweb.base.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 页面控制器增强
 */
@ControllerAdvice
public class PageControllerAdvice {



    @ModelAttribute
    public void addAttributes(Model model, HttpServletRequest request, HttpServletResponse response) {
        // 设定basePath
        String basePath = request.getContextPath();
        request.setAttribute("basePath", basePath);
        /*// 默认title
        model.addAttribute("title", "我的测试系统");
        // 默认媒体头文件
        model.addAttribute("defaultMetaName", "basic_meta");
        // 默认css文件
        model.addAttribute("defaultStyleName", "basic_style");
        // 默认脚本文件
        model.addAttribute("defaultScriptName", "basic_script");
        // 默认模板
        model.addAttribute("pageName", "index");*/
    }



}
