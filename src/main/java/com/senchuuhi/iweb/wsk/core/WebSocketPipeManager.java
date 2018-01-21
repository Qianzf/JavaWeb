package com.senchuuhi.iweb.wsk.core;

import com.senchuuhi.iweb.wsk.entity.WSMethods;

import javax.websocket.Session;
import java.util.List;

/**
 * web socket 通道管理器
 */
public class WebSocketPipeManager {

    private static List<WSMethods> methodsList = null;

    static {
        methodsList = WebSocketInit.getSocketPipeMethods();
    }

    public void init (Session session) {

    }


}
