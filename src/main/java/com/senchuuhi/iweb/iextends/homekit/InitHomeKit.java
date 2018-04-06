package com.senchuuhi.iweb.iextends.homekit;

import com.beowulfe.hap.HomekitServer;
import com.senchuuhi.iweb.iextends.homekit.bridge.BaseBridge;

import java.io.IOException;

public class InitHomeKit {

    private static final int PORT = 9123;

    public static void init() {
        try {
            HomekitServer homekit = new HomekitServer(PORT);
            new BaseBridge(homekit);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
