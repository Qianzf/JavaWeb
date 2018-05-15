package com.senchuuhi.iweb.system.manage.controller;


import com.senchuuhi.iweb.base.controller.FrontBaseController;
import com.senchuuhi.iweb.base.model.ViewModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 数据发布控制器
 */
@Controller
@RequestMapping("/manage/publish")
public class PublishController extends FrontBaseController {


    @RequestMapping("/article")
    public ViewModel index(Model model) {
        model.addAttribute(PAGE_NAME,"manage/publish/article_manage");
        return super.getView();
    }

}
