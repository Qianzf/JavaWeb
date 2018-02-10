package com.senchuuhi.iweb.websocket.socketservice;

import com.senchuuhi.iweb.wsk.atiface.WS;
import com.senchuuhi.iweb.wsk.core.WebSocketAuthAlgorithm;
import com.senchuuhi.iweb.wsk.entity.WSReturn;
import com.senchuuhi.iweb.wsk.iface.WSApi;
import org.springframework.stereotype.Component;

import javax.websocket.Session;
import java.util.Date;
import java.util.Map;

/**
 * 登录相关指令
 */
@Component
public class LoginAuthApi implements WSApi {

    @WS(command = "login")
    public WSReturn login(Session session, Map<String, String> map) {
        WSReturn wsr = new WSReturn();
        String username = map.get("username");
        String password = map.get("password");
        if (username != null && password != null && username.equals("admin") && password.equals("admin")) {
            String message = WebSocketAuthAlgorithm.encryptByPublicKey("admin,admin" + new Date().getTime());
            wsr.setMessage("login success");
            wsr.setData(message);
            wsr.setStatus(true);
        } else {
            wsr.setStatus(false);
            wsr.setMessage("用户名/密码错误！");
        }
        return wsr;
    }

    @WS(command = "auth")
    public WSReturn auth(Session session, Map<String, String> map) {
        WSReturn wsr = new WSReturn();
        String data = map.get("auth");
        // 解密用户名和密码
        String tmp = WebSocketAuthAlgorithm.decryptByPrivateKey(data);
        if (tmp == null) {
            wsr.setMessage("登陆状态改变！请重新登陆");
            wsr.setStatus(false);
        } else {
            String[] userinfos = tmp.split(",");
            if (userinfos.length == 3) {
                String username = userinfos[0];
                String password = userinfos[1];
                String logintimestamp = userinfos[2];
                if ("admin".equals(username) && "admin".equals(password)) {
                    wsr.setStatus(true);
                } else {
                    wsr.setMessage("登陆状态改变！请重新登陆" + tmp);
                    wsr.setStatus(false);
                }
            }
        }
        return wsr;
    }

}
