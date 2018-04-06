package com.senchuuhi.iweb.iextends.homekit.bridge;

import com.beowulfe.hap.HomekitRoot;
import com.beowulfe.hap.HomekitServer;
import com.senchuuhi.iweb.iextends.homekit.auth.MockAuthInfo;
import com.senchuuhi.iweb.iextends.homekit.devices.MockAdjust;
import com.senchuuhi.iweb.iextends.homekit.devices.MockSwitch;


import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;

public class BaseBridge {

    public BaseBridge(HomekitServer homekit) {

        try {
            HomekitRoot bridge = homekit.createBridge(new MockAuthInfo(), "虚拟设备桥接器", "虚拟桥接设备提供商.", "X-01", "virtual0000001");
            bridge.addAccessory(new MockSwitch());
            bridge.addAccessory(new MockAdjust());
            bridge.start();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }

    }

}
