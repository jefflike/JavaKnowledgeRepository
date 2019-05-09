package com.jeffcode.listenerdemo;

import org.springframework.context.ApplicationEvent;

/**
 * @Author: jefflike
 * @create: 2019/5/8
 * @describe:
 */
public class MyApplicationEvent extends ApplicationEvent {
    public MyApplicationEvent(Object source) {
        super(source);
    }
}
