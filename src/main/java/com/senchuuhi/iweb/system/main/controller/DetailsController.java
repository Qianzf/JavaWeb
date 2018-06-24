package com.senchuuhi.iweb.system.main.controller;

import com.senchuuhi.iweb.auto.entity.AxeArticle;
import com.senchuuhi.iweb.base.controller.FrontBaseController;
import com.senchuuhi.iweb.base.model.ResponseModel;
import com.senchuuhi.iweb.base.model.ViewModel;
import com.senchuuhi.iweb.system.main.service.AxeArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 详情页
 */
@Controller
@RequestMapping("/details")
public class DetailsController extends FrontBaseController {

    @Autowired
    private AxeArticleService axeArticleService;

    @RequestMapping(value={"/{id}.html"})
    public ViewModel details(Model model, @PathVariable("id") String id) {
        System.out.println("id" + id);

        ResponseModel response = this.axeArticleService.getArticlesInfoById(Integer.valueOf(id));
        AxeArticle axeArticle = (AxeArticle)response.getData();
        if (axeArticle == null) {
            axeArticle = new AxeArticle();
            axeArticle.setArticleName("禁止访问");
            axeArticle.setArticleContent("本页面内容已被管理员设置禁止访问。");
        }
        model.addAttribute("acticle_title", axeArticle.getArticleName());
        model.addAttribute("acticle_content", axeArticle.getArticleContent());
        return super.getView("main/details");
    }

}
