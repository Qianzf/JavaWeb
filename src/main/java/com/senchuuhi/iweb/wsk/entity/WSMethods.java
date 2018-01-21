package com.senchuuhi.iweb.wsk.entity;

import com.senchuuhi.iweb.wsk.iface.WSApi;

import java.lang.reflect.Method;

public class WSMethods {

    private int priority = -1;

    private Method method = null;

    private WSApi socketService = null;

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public WSApi getSocketService() {
        return socketService;
    }

    public void setSocketService(WSApi socketService) {
        this.socketService = socketService;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
