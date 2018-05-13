package com.senchuuhi.iweb.base.controller;

import com.senchuuhi.iweb.auto.entity.AxeUser;
import com.senchuuhi.iweb.base.constants.BaseConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;

/**
 * 基础控制器
 */
public class BaseController implements BaseConstants{

    /** 日志 **/
    public final Logger logger = LoggerFactory.getLogger(this.getClass());

    public AxeUser getUser(HttpServletRequest request) {
        AxeUser user = (AxeUser) request.getSession().getAttribute(SESSION_USER);
        return user;
    }

}
