package com.senchuuhi.iweb.system.main.controller;


import com.senchuuhi.iweb.base.controller.FrontBaseController;
import com.senchuuhi.iweb.base.model.ViewModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pages")
public class PagesController  extends FrontBaseController {

    @RequestMapping(value={"", "/"})
    public ViewModel pages(Model model) {
        return super.getView("main/pages");
    }
}
