package com.senchuuhi.iweb.controller;

import com.senchuuhi.iweb.base.entity.RequestEntity;
import com.senchuuhi.iweb.base.entity.ResponseEntity;
import com.senchuuhi.iweb.service.acore.iface.RequestDispatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * 数据请求统一处理Url
 *
 */
@RestController
@RequestMapping("/")
public class RequestHanderController {

    /** 请求分发器 **/
    @Autowired
    RequestDispatcher requestDispatcher = null;

    public ResponseEntity hander(RequestEntity entity, HttpServletRequest request, HttpServletResponse response) {
        return requestDispatcher.handerRequest(entity, request, response);
    }

}
