package com.jeffcode.listenerdemo;

import org.springframework.context.ApplicationListener;

/**
 * @Author: jefflike
 * @create: 2019/5/8
 * @describe:
 */
public class MyApplicationListener implements ApplicationListener<MyApplicationEvent> {
    @Override
    public void onApplicationEvent(MyApplicationEvent myApplicationEvent) {
        System.out.println(myApplicationEvent.getClass().getName() + "被监听");
    }
}
