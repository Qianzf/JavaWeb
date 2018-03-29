package com.senchuuhi.iweb;


import com.beowulfe.hap.HomekitAuthInfo;
import com.beowulfe.hap.HomekitCharacteristicChangeCallback;
import com.beowulfe.hap.HomekitRoot;
import com.beowulfe.hap.HomekitServer;
import com.beowulfe.hap.accessories.DimmableLightbulb;
import com.beowulfe.hap.accessories.Lightbulb;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@SpringBootApplication
@EnableAutoConfiguration
@MapperScan("com.senchuuhi.iweb.auto")
public class StartPoint {




    public static void main(String[] args) {
        //SpringApplication.run(StartPoint.class, args);

    }

}

