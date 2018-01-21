package com.senchuuhi.iweb.wsk.core;

import com.senchuuhi.iweb.wsk.atiface.WS;
import com.senchuuhi.iweb.wsk.atiface.WSPIPE;
import com.senchuuhi.iweb.wsk.entity.WSMethods;
import com.senchuuhi.iweb.wsk.iface.WSApi;
import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.*;


public class WebSocketInit implements ApplicationContextAware {

    private static Logger log = Logger.getLogger(WebSocketInit.class);

    private static ApplicationContext applicationContext;

    // 获取所有该类型的socket
    private static Map<String, WSMethods> socketCommandMethods;

    // 数据管道方法
    private static List<WSMethods> socketPipeMethods;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        if (WebSocketInit.applicationContext == null) {
            log.info("============================================================================");
            log.info("iweb 正在启动...                                                                ");
            log.info("正在获取applicationContext...");
            WebSocketInit.applicationContext = applicationContext;

            log.info("正在扫描socket bean（继承WSApi接口的SpringBean）...");
            Map<String, WSApi> tmp = WebSocketInit.applicationContext.getBeansOfType(WSApi.class);
            log.info("已经获取socket bean, 数量:" + tmp.keySet().size());

            log.info("正在扫描指令和数据管道...");
            WebSocketInit.socketCommandMethods = initMethodsData(tmp);
            log.info("数据管道扫描完成。数据管道数：" + socketPipeMethods.size());
            log.info("系统指令扫描完成。所有指令数：" + WebSocketInit.socketCommandMethods.keySet().size());

            // 初始化公钥和私钥
            WebSocketAuthAlgorithm.initKey();
            log.info("iweb 已启动完成！                                                             ");
            log.info("============================================================================");
        }

    }

    // 初始化数据指令
    private Map<String, WSMethods> initMethodsData(Map<String, WSApi> socketServiceMap) {
        HashMap<String, WSMethods> map = new HashMap<>();
        socketPipeMethods = new ArrayList<>();
        // 指令匹配（只允许匹配一个，多个不允许！）
        for (String key : socketServiceMap.keySet()) {
            // 获取有效的socket service
            WSApi service = socketServiceMap.get(key);
            // 所有的类
            Class clazz = service.getClass();
            // 方法集合
            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                // 注解
                WS ws = method.getAnnotation(WS.class);
                WSPIPE wspipe = method.getAnnotation(WSPIPE.class);
                if (ws != null) {
                    // 获取command
                    String definedCommand = ws.command();
                    // 方法集合
                    WSMethods wsm = map.get(definedCommand);
                    if (wsm == null) {
                        wsm = new WSMethods();
                        wsm.setSocketService(service);
                        wsm.setMethod(method);
                        map.put(definedCommand, wsm);
                    } else {
                        log.error("系统检测到重复指令，初始化失败！系统即将退出");
                        log.error("错误指令：" + definedCommand);
                        log.error("既存在于："
                                + wsm.getSocketService().getClass().getName()
                                + "."
                                + wsm.getMethod().getName()
                                + "()");
                        log.error("又存在于："
                                + service.getClass().getName()
                                + "."
                                + method.getName()
                                + "()");
                        log.info("------------------------------------------------------------------------");
                        System.exit(-1);
                    }
                }

                if (wspipe != null) {
                    WSMethods wsm = new WSMethods();
                    wsm.setPriority(wspipe.priority());
                    wsm.setSocketService(service);
                    wsm.setMethod(method);
                    socketPipeMethods.add(wsm);
                }

            }
        }
        if (socketPipeMethods != null) {
            // 对管道进行排序
            Collections.sort(socketPipeMethods,new Comparator<WSMethods>(){
                public int compare(WSMethods arg0, WSMethods arg1) {
                    return arg0.getPriority() - arg1.getPriority();
                }
            });
        }
        return map;
    }

    public static ApplicationContext getApplicationContext() {
        return WebSocketInit.applicationContext;
    }

    public static Map<String, WSMethods> getSocketCommandMethods() {
        return WebSocketInit.socketCommandMethods;
    }

    public static List<WSMethods> getSocketPipeMethods() {
        return WebSocketInit.socketPipeMethods;
    }

}
