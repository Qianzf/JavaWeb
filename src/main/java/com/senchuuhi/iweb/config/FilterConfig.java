package com.senchuuhi.iweb.config;

import com.senchuuhi.iweb.interrupt.SessionFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
public class FilterConfig {

    @Bean
    public Filter sessionFilter() {
        return new SessionFilter();
    }

    @Bean
    public FilterRegistrationBean someFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(sessionFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("sessionFilter");
        // 配置顶级过滤器
        registration.setOrder(Integer.MAX_VALUE);
        return registration;
    }

}
