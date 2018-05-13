package com.senchuuhi.iweb.system.article.controller;

import com.senchuuhi.iweb.base.controller.FrontBaseController;
import com.senchuuhi.iweb.base.model.ResponseModel;
import com.senchuuhi.iweb.system.article.service.AxeArticleService;
import net.sf.json.util.JSONUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/articles")
public class AxeArticleController extends FrontBaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AxeArticleService axeArticleService;

    /**
     * 文章列表页面显示
     * @return
     */
    @RequestMapping("/main")
    public String articleMainPage (Model model, Integer pageNumber, Integer pageSize) {
        this.logger.info("------------------------------------------>");
        ResponseModel result = this.axeArticleService.getArticlesList(pageNumber, pageSize);
        model.addAttribute("data", JSONUtils.valueToString(result));
        this.logger.info("------------------------------------------<");

        return "articles/main";
    }
}
