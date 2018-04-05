package com.senchuuhi.iweb.modules.main.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页控制器
 */
@Controller
@RequestMapping("/")
public class MainController {


    @RequestMapping("/")
    public String main(Model model) {
        return "layout/basic";
    }

}
