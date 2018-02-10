package com.senchuuhi.iweb.service.acore.iface;

import com.senchuuhi.iweb.base.entity.RequestEntity;
import com.senchuuhi.iweb.base.entity.ResponseEntity;
import com.senchuuhi.iweb.service.acore.constants.AcoreConstants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 请求分发器。
 */
public interface RequestDispatcher extends AcoreConstants {

    public ResponseEntity handerRequest(RequestEntity entity, HttpServletRequest request, HttpServletResponse response);

}
