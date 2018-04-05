package com.senchuuhi.iweb;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
@MapperScan("com.senchuuhi.iweb.auto")
public class StartPoint {


    public static void main(String[] args) {
        SpringApplication.run(StartPoint.class, args);
        // InitHomeKit.init();
        // new InitSmartQQ().login();
    }

}

