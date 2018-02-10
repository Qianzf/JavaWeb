package com.senchuuhi.iweb.service.acore.impl;

import com.senchuuhi.iweb.base.entity.RequestEntity;
import com.senchuuhi.iweb.base.entity.ResponseEntity;
import com.senchuuhi.iweb.base.startup.SpringStartUp;
import com.senchuuhi.iweb.service.acore.iface.RequestDispatcher;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 默认的请求分发器。
 */
@Service
public class DefaultRequestDispatcherImpl implements RequestDispatcher {


    @Override
    public ResponseEntity handerRequest(RequestEntity entity, HttpServletRequest request, HttpServletResponse response) {

        ApplicationContext applicationContext = SpringStartUp.getApplicationContext();

        return null;
    }
}
