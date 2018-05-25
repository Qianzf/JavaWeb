package com.senchuuhi.iweb.base.controller;

import com.senchuuhi.iweb.base.constants.BaseConstants;
import com.senchuuhi.iweb.base.constants.LayoutConstants;
import com.senchuuhi.iweb.base.model.ViewModel;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 后端管理页面控制器
 */
public class ManageBaseController extends BaseController implements BaseConstants{

    @ModelAttribute
    public final void initResponse(Model model) {
        // 默认title
        model.addAttribute(PAGE_TITLE, DEFAULT_PAGE_TITLE);
        // 默认媒体头文件
        model.addAttribute(PAGE_META, DEFAULT_PAGE_META);
        // 默认css文件
        model.addAttribute(PAGE_STYLE, "manage_style");
        // 默认脚本文件
        model.addAttribute(PAGE_SCRIPT, "manage_script");
        // 默认模板
        model.addAttribute(PAGE_NAME, DEFAULT_PAGE_NAME);
    }

    /**
     * 设定默认布局页面
     * @return
     */
    public ViewModel getView() {
        ViewModel model = new ViewModel();
        model.setViewName(LayoutConstants.PAGE_LAYOUT_BASE);
        return model;
    }

}
