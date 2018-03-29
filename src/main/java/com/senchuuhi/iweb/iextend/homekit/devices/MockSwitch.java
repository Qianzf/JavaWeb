package com.senchuuhi.iweb.iextend.homekit.devices;

import com.beowulfe.hap.HomekitCharacteristicChangeCallback;
import com.beowulfe.hap.accessories.Lightbulb;

import java.util.concurrent.CompletableFuture;

public class MockSwitch implements Lightbulb {

    private boolean powerState = false;
    private HomekitCharacteristicChangeCallback subscribeCallback = null;

    @Override
    public int getId() {
        return 2;
    }

    @Override
    public String getLabel() {
        return "灯光开关测试";
    }

    @Override
    public void identify() {
        System.out.println("认证 light");
    }

    @Override
    public String getSerialNumber() {
        return "112233445566";
    }

    @Override
    public String getModel() {
        return "8888";
    }

    @Override
    public String getManufacturer() {
        return "";
    }

    @Override
    public CompletableFuture<Boolean> getLightbulbPowerState() {
        return CompletableFuture.completedFuture(powerState);
    }

    @Override
    public CompletableFuture<Void> setLightbulbPowerState(boolean powerState)
            throws Exception {
        this.powerState = powerState;
        if (subscribeCallback != null) {
            subscribeCallback.changed();
        }
        System.out.println("当前状态： "+(powerState ? "on" : "off"));
        return CompletableFuture.completedFuture(null);
    }

    @Override
    public void subscribeLightbulbPowerState(
            HomekitCharacteristicChangeCallback callback) {
        this.subscribeCallback = callback;
    }

    @Override
    public void unsubscribeLightbulbPowerState() {
        this.subscribeCallback = null;
    }

}