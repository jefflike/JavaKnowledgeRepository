package com.jeffcode.listenerdemo;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @Author: jefflike
 * @create: 2019/5/9
 * @describe:
 * 加上注解就被监听了，主要此handler需要被ioc管理
 */
@Component
public class MyEventHandler {
    @EventListener
    public void listener(MyApplicationEvent myApplicationEvent) {
        System.out.println("第四种注入方式");
    }
}
