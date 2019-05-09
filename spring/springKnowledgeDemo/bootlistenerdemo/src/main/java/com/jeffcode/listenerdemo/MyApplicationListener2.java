package com.jeffcode.listenerdemo;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Author: jefflike
 * @create: 2019/5/8
 * @describe:
 * 第二种方式注入监听器，也就是说所有继承ApplicationListener，ioc容器启动的时候refresh()都会监听了。
 */
@Component("MyApplicationListener2")
public class MyApplicationListener2 implements ApplicationListener<MyApplicationEvent> {
    @Override
    public void onApplicationEvent(MyApplicationEvent myApplicationEvent) {
        System.out.println(myApplicationEvent.getClass().getName() + "2被监听");
    }
}
