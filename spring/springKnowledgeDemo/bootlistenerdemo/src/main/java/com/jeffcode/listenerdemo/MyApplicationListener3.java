package com.jeffcode.listenerdemo;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Author: jefflike
 * @create: 2019/5/8
 * @describe:
 * 直接在yaml配置
 */
public class MyApplicationListener3 implements ApplicationListener<MyApplicationEvent> {
    @Override
    public void onApplicationEvent(MyApplicationEvent myApplicationEvent) {
        System.out.println(myApplicationEvent.getClass().getName() + "3被监听");
    }
}
