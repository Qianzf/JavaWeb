package com.senchuuhi.iweb.base.advice;

import com.senchuuhi.iweb.base.startup.SpringStartUp;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * 页面建言
 */
@ControllerAdvice
public class PageControllerAdvice {



    @ModelAttribute
    public void addAttributes(Model model) {
        // 默认title
        model.addAttribute("title", "我的测试系统");
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
