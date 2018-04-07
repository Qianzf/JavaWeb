package com.senchuuhi.iweb.functions.install.controller;


import com.senchuuhi.iweb.base.constants.LayoutConstants;
import com.senchuuhi.iweb.functions.install.service.InstallSQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView main(Model model) {
        // 设定页面
        String tipInfo = "安装成功！";
        int status = iss.initSql(true, true);
        switch(status) {
            case 1:
                tipInfo = "";
                break;
            case -1:
                tipInfo = "表数据已经存在！是否覆盖安装？";
                break;
            case -2:
                tipInfo = "表创建过程中出现未知异常！";
                break;
        }
        model.addAttribute("tipInfo",tipInfo);
        model.addAttribute("pageName","install/index");
        // 返回基本布局
        return new ModelAndView(LayoutConstants.PAGE_LAYOUT_BASE);
    }

}
