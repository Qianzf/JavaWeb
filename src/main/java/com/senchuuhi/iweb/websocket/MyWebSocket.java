package com.senchuuhi.iweb.websocket;

import com.senchuuhi.iweb.wsk.core.WebSocketApi;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/isocket")
@Component
public class MyWebSocket {

    private Logger log = Logger.getLogger(this.getClass());

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session) {
        WebSocketApi.onOpen(session);
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(Session session) {
        WebSocketApi.onClose(session);
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public synchronized void onMessage(String message, Session session) {
        WebSocketApi.onMessage(message, session);
    }

    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误" + error.getMessage());
        //error.printStackTrace();
    }

}