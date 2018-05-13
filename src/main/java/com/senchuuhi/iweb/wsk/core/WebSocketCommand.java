package com.senchuuhi.iweb.wsk.core;

import com.senchuuhi.iweb.wsk.entity.WSMethods;
import com.senchuuhi.iweb.wsk.entity.WSReturn;
import com.senchuuhi.iweb.wsk.extend.WSUtils;
import com.senchuuhi.iweb.wsk.iface.WSApi;
import org.apache.log4j.Logger;

import javax.websocket.Session;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class WebSocketCommand {

    private static Map<String, String> baseCommand = new HashMap<>();

    private static Logger log = Logger.getLogger(WebSocketCommand.class);

    // 获取所有该类型的socket
    private static Map<String, WSMethods> socketCommandMethods;

    static {
        baseCommand.put("ping", "pong");
        baseCommand.put("1", "1");
        baseCommand.put("version", "0.0.1");
        WebSocketCommand.socketCommandMethods = WebSocketInit.getSocketCommandMethods();
    }

    // 根据指令获取数据信息
    public static WSReturn getData(String orignCommand, Session session) {
        WSReturn wsReturn = new WSReturn();
        // 指令获取
        String command = WSUtils.getCommandFromOrignCommand(orignCommand);
        // 无效指令判定
        if (command == null ) {
            wsReturn.setData("empty command");
            wsReturn.setCommand("");
            wsReturn.setStatus(false);
            return wsReturn;
        }

        wsReturn.setCommand(command);
        wsReturn.setOrginCommand(orignCommand);

        // 基本指令不允许覆盖
        if (baseCommand.containsKey(command)) {
            wsReturn.setData(baseCommand.get(command));
            wsReturn.setStatus(true);
            return wsReturn;
        }

        for (String definedCommand : socketCommandMethods.keySet()) {
            if (definedCommand != null && command.equals(definedCommand)) {
                WSMethods wsm = socketCommandMethods.get(definedCommand);
                return excuseMethod(wsm.getSocketService(), wsm.getMethod(), session, orignCommand, command);
            }
        }

        wsReturn.setStatus(false);
        wsReturn.setMessage("Command is not exist!");
        log.error("command :" + command + " is not exist.");
        //
        return wsReturn;
    }

    /**
     * 执行方法
     *
     * @param service      system
     * @param method       method
     * @param session      session
     * @param orignCommand orignCommand
     * @return String
     */
    public static WSReturn excuseMethod(WSApi service, Method method, Session session, String orignCommand, String commond) {
        // 传递参数
        // tmpService.setMessage(orignCommand);
        Object obj = null;
        try {

            // 参数类型判定
            Class[] clazzs = method.getParameterTypes();
            Object[] objs = new Object[clazzs.length];
            // 传入参数设定
            for (int i = 0; i < clazzs.length; ++i) {
                Class clazz = clazzs[i];
                if (clazz.isAssignableFrom(javax.websocket.Session.class)) {
                    objs[i] = session;
                } else if (clazz.isAssignableFrom(java.util.Map.class)) {
                    objs[i] = WSUtils.getMapFromData(orignCommand);
                } else if (clazz.isAssignableFrom(java.util.List.class)) {
                    objs[i] = WSUtils.getListFromData(orignCommand);
                } else {
                    objs[i] = null;
                }
            }
            // 执行方法
            obj = method.invoke(service, objs);
        } catch (IllegalAccessException e) {
            // e.printStackTrace();
            log.error("无法执行该方法(IllegalAccessException) : ");
            e.getCause().printStackTrace();
        } catch (InvocationTargetException e) {
            log.error("指令方法执行错误(InvocationTargetException) : ");
            e.getCause().printStackTrace();
        }

        if (obj != null && obj instanceof WSReturn) {
            ((WSReturn) obj).setOrginCommand(orignCommand);
            ((WSReturn) obj).setCommand(commond);
            return (WSReturn) obj;
        } else if (obj != null ) {
            WSReturn wsr = new WSReturn();
            wsr.setData(obj);
            wsr.setOrginCommand(orignCommand);
            wsr.setCommand(commond);
            return wsr;
        } else {
            return null;
        }
    }

}
