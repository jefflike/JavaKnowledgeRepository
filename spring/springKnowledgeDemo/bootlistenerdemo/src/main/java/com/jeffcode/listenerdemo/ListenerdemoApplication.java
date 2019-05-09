package com.jeffcode.listenerdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/*
* 第一种方式注入监听器和监听事件
* */
@SpringBootApplication
public class ListenerdemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(ListenerdemoApplication.class, args);
        // 添加自定义监听器
        applicationContext.addApplicationListener(new MyApplicationListener());
        // 发布监听事件
        applicationContext.publishEvent(new MyApplicationEvent(new Object()));
    }

}
