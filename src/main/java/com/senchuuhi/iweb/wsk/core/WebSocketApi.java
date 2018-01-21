package com.senchuuhi.iweb.wsk.core;

import com.senchuuhi.iweb.wsk.entity.WSReturn;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;

import javax.websocket.Session;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

public class WebSocketApi {

    private static Logger log = Logger.getLogger(WebSocketApi.class);

    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
    private static CopyOnWriteArraySet<Session> webSocketSet = new CopyOnWriteArraySet<Session>();

    // 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;

    public static void onMessage(String message, Session session) {
        //
        log.info("message:" + message);
        WSReturn wsr = WebSocketCommand.getData(message.trim(), session);
        try {
            sendMessage(JSONObject.fromObject(wsr).toString(), session);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("IO异常");
        }
    }

    public static void onOpen(Session session) {
        webSocketSet.add(session);     //加入set中
        addOnlineCount();           //在线数加1
        log.info("有新连接加入！当前创建的链接数为" + getOnlineCount());
        // session 通道管理器

        try {
            WSReturn wsr = new WSReturn();
            wsr.setMessage("linked");
            sendMessage(JSONObject.fromObject(wsr).toString(), session);
        } catch (IOException e) {
            log.info("IO异常");
        }
    }

    public static void onClose(Session session) {
        webSocketSet.remove(session);  //从set中删除
        subOnlineCount();           //在线数减1
        log.info("有一连接关闭！当前创建的链接数为" + getOnlineCount());
    }

    /**
     * 群发自定义消息
     */
    public static void sendAllInfo(String message) throws IOException {
        for (Session item : webSocketSet) {
            try {
                sendMessage(message, item);
            } catch (IOException e) {
                continue;
            }
        }
    }

    private static void sendMessage(String message, Session session) throws IOException {
        session.getBasicRemote().sendText(message);
        //this.session.getAsyncRemote().sendText(message);
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    private static synchronized void addOnlineCount() {
        WebSocketApi.onlineCount++;
    }

    private static synchronized void subOnlineCount() {
        WebSocketApi.onlineCount--;
    }

}
