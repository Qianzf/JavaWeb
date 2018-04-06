package com.senchuuhi.iweb.functions.install.controller;


import com.senchuuhi.iweb.base.constants.LayoutConstants;
import com.senchuuhi.iweb.functions.install.service.InstallSQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 系统安装控制器
 */
@Controller
@RequestMapping("/install")
public class InstallController {


    @Autowired
    private InstallSQLService iss;

    /**
     * 判断是否要进行系统安装
     * @param model
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/index")
    public String index(Model model, HttpServletRequest request, HttpServletResponse response) {
        try {
            // 跳转到安装页面

            response.sendRedirect(request.getContextPath() + "/install/next");
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 返回基本布局
        return null;
    }

    /**
     * 进行系统安装
     * @param model
     * @return
     */
    @RequestMapping("/next")
    public String main(Model model) {
        // 设定页面
        iss.isSqlInited();
        model.addAttribute("pageName","install/index");
        // 返回基本布局
        return LayoutConstants.PAGE_LAYOUT_BASE;
    }

}
