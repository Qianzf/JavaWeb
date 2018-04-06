package com.senchuuhi.iweb.iextends.homekit.devices;

import com.beowulfe.hap.HomekitCharacteristicChangeCallback;
import com.beowulfe.hap.accessories.DimmableLightbulb;

import java.util.concurrent.CompletableFuture;

public class MockAdjust implements DimmableLightbulb {

    private boolean powerState = false;
    private int lightNum = 50;
    private HomekitCharacteristicChangeCallback subscribeCallback = null;

    @Override
    public int getId() {
        return 3;
    }

    @Override
    public String getLabel() {
        return "可调节亮度开关";
    }

    @Override
    public void identify() {
        System.out.println("认证 可调节light");
    }

    @Override
    public String getSerialNumber() {
        return "123456";
    }

    @Override
    public String getModel() {
        return "9999";
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
        System.out.println("当前状态： " + (powerState ? "on" : "off"));
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

    @Override
    public CompletableFuture<Integer> getBrightness() {

        return CompletableFuture.completedFuture(lightNum);
    }

    @Override
    public CompletableFuture<Void> setBrightness(Integer integer) throws Exception {
        System.out.println("当前亮度：" + integer);
        return CompletableFuture.completedFuture(null);
    }

    @Override
    public void subscribeBrightness(HomekitCharacteristicChangeCallback homekitCharacteristicChangeCallback) {

    }

    @Override
    public void unsubscribeBrightness() {

    }
}