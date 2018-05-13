package com.senchuuhi.iweb.base.controller;

import com.senchuuhi.iweb.base.constants.BaseConstants;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 前端页面控制器
 */
public class FrontBaseController extends BaseController implements BaseConstants{

    @ModelAttribute
    public final void initResponse(Model model, HttpServletRequest request, HttpServletResponse response) {
        // 默认title
        model.addAttribute("title", "AXE—Default Page");
        // 默认媒体头文件
        model.addAttribute("defaultMetaName", "basic_meta");
        // 默认css文件
        model.addAttribute("defaultStyleName", "basic_style");
        // 默认脚本文件
        model.addAttribute("defaultScriptName", "basic_script");
        // 默认模板
        model.addAttribute("pageName", "index");
    }

}
