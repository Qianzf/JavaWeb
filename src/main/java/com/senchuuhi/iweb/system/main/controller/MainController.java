package com.senchuuhi.iweb.system.main.controller;


import com.senchuuhi.iweb.base.controller.FrontBaseController;
import com.senchuuhi.iweb.base.model.ViewModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页控制器
 */
@Controller
@RequestMapping("/")
public class MainController extends FrontBaseController {


    @RequestMapping("")
    public ViewModel index(Model model) {
        return super.getView();
    }

}
