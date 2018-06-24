package com.senchuuhi.iweb.system.main.controller;


import com.alibaba.fastjson.JSONObject;
import com.senchuuhi.iweb.base.controller.FrontBaseController;
import com.senchuuhi.iweb.base.model.ResponseModel;
import com.senchuuhi.iweb.base.model.ViewModel;
import com.senchuuhi.iweb.system.main.service.AxeArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 系统首页
 */
@Controller
@RequestMapping("/")
public class MainController extends FrontBaseController {

    @Autowired
    private AxeArticleService axeArticleService;

    @RequestMapping(value={"", "/"})
    public ViewModel index(Model model, Integer pageNum, Integer pageSize, String keyword) {
        if (pageNum == null || pageSize == null) {
            pageNum = 1;
            pageSize = 10;
        }
        if (keyword == null) {
            keyword = "";
        }
        ResponseModel response = axeArticleService.getArticlesList(pageNum, pageSize, keyword);
        model.addAttribute("response", JSONObject.toJSONString(response));
        model.addAttribute("keyword", keyword);
        return super.getView();
    }

}
