package com.senchuuhi.iweb.system.main.controller;


import com.senchuuhi.iweb.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页控制器
 */
@Controller
@RequestMapping("/")
public class MainController extends BaseController {


    @RequestMapping("")
    public String index(Model model) {

        // 返回基本布局
        return "main/index";
    }

}
