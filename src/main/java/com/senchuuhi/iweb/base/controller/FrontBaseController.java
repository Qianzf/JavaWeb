package com.senchuuhi.iweb.base.controller;

import com.senchuuhi.iweb.base.constants.BaseConstants;
import com.senchuuhi.iweb.base.constants.LayoutConstants;
import com.senchuuhi.iweb.base.model.ViewModel;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * 前端页面控制器
 */
public class FrontBaseController extends BaseController implements BaseConstants{

    @ModelAttribute
    public final void initResponse(Model model) {

        // 默认title
        model.addAttribute(PAGE_TITLE, DEFAULT_PAGE_TITLE);
        // 默认媒体头文件
        model.addAttribute(PAGE_META, DEFAULT_PAGE_META);
        // 默认css文件
        model.addAttribute(PAGE_STYLE, DEFAULT_PAGE_STYLE);
        // 默认脚本文件
        model.addAttribute(PAGE_SCRIPT, DEFAULT_PAGE_SCRIPT);
        // 默认模板
        model.addAttribute(PAGE_NAME, DEFAULT_PAGE_NAME);
    }

    public ViewModel getView() {
        ViewModel model = new ViewModel();
        model.setViewName(LayoutConstants.PAGE_LAYOUT_BASE);
        return model;
    }

}
