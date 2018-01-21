package com.senchuuhi.iweb.wsk.core;

import com.senchuuhi.iweb.wsk.iface.WSSecurity;

import javax.websocket.Session;
import java.util.List;
import java.util.Map;

/**
 * WebSocket权限管理模块
 */
public class WebSocketSecurity {


    /**
     * 提供当前用户的角色信息
     **/
    public static String getUserRole() {
        return "all";
    }

    public static boolean vaildUserPromise(Session session) {


        return true;
    }

    /**
     * 为session设置用户角色
     * @param session
     */
    public static void setUserRoleForSession(Session session) {
        Map<String, List<String>> maps = session.getRequestParameterMap();
        String query = session.getQueryString();
        maps.forEach((map, list) -> System.out.println(map + " | " + list.get(0)));
        // 获取用户的请求map
        session.getRequestParameterMap();
    }

    public static void getUserRoleFromSession(Session session) {

    }

}
