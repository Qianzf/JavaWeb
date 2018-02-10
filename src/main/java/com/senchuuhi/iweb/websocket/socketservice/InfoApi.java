package com.senchuuhi.iweb.websocket.socketservice;

import com.senchuuhi.iweb.wsk.atiface.WS;
import com.senchuuhi.iweb.wsk.entity.WSReturn;
import com.senchuuhi.iweb.wsk.iface.WSApi;
import org.springframework.stereotype.Component;

import javax.websocket.Session;
import java.util.Map;

/**
 * 获取信息的api
 */
@Component
public class InfoApi implements WSApi {



    @WS(command = "info")
    public WSReturn auth(Session session, Map<String, String> map) {
        WSReturn wsr = new WSReturn();
        return wsr;
    }

}
