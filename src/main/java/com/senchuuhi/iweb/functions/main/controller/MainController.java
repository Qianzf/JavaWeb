package com.senchuuhi.iweb.functions.main.controller;


import com.senchuuhi.iweb.base.constants.LayoutConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 首页控制器
 */
@Controller
@RequestMapping("/")
public class MainController {


    @RequestMapping("/")
    public String index(Model model) {

        // 返回基本布局
        return LayoutConstants.PAGE_LAYOUT_BASE;
    }

    @RequestMapping("/main")
    public ModelAndView main(Model model) {

        // 设定页面
        model.addAttribute("pageName","main/index");
        // 返回基本布局
        return new ModelAndView(LayoutConstants.PAGE_LAYOUT_BASE);
    }

}
