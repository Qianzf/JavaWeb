package com.senchuuhi.iweb.interrupt;

import com.senchuuhi.iweb.base.startup.WebVisitStartUp;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 全局过滤器配置
 */
@Component
public class SessionFilter implements Filter {

    private Logger logger = Logger.getLogger(SessionFilter.class);

    @Value("${application.cros.visit}")
    private String cosVisit;

    @Autowired
    private WebVisitStartUp webVisitStartUp;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        // 转换类型
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;


        if ("true".equals(cosVisit)) {
            httpResponse.setHeader("Access-Control-Allow-Origin", "*");
            httpResponse.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
            httpResponse.setHeader("Access-Control-Max-Age", "1800");
            httpResponse.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
            httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
        }


        // 调用页面访问监听
        webVisitStartUp.doSomeThing(httpRequest, httpResponse);

        filterChain.doFilter(servletRequest, httpResponse);
    }

    @Override
    public void destroy() {

    }
}
