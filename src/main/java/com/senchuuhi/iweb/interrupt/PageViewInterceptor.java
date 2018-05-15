package com.senchuuhi.iweb.interrupt;

import com.senchuuhi.iweb.base.constants.LayoutConstants;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 页面访问拦截器
 */
public class PageViewInterceptor implements HandlerInterceptor {

    private Logger logger = Logger.getLogger(PageViewInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        if (modelAndView == null) {
            modelAndView = new ModelAndView();
        }
        logger.info("视图名称：" + modelAndView.getViewName());
        modelAndView.setViewName(LayoutConstants.PAGE_LAYOUT_BASE);
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        logger.info("res：" + o.toString());
    }
}
