package com.senchuuhi.iweb;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
@EnableAutoConfiguration
@MapperScan("com.senchuuhi.iweb.auto")
public class StartPoint {


    public static void main(String[] args) {
        SpringApplication.run(StartPoint.class, args);
        // 系统启动完成后打开网址
        openUrl("http://localhost/");
    }

    public static void openUrl(String url) {
        String browspath = System.getProperty("brows.path");
        try {
            if (browspath != null) {
                Runtime.getRuntime().exec("browspath " + url);
            } else {
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

