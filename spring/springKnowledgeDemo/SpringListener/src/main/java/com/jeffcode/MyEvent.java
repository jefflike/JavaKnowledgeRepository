package com.jeffcode;

import org.springframework.context.ApplicationEvent;

/**
 * @Author: jefflike
 * @create: 2019/5/7
 * @describe:
 */
public class MyEvent extends ApplicationEvent {
    private static final long serialVersionID = 1L;

    // 收件人
    public String receiver;

    // 收件内容
    public String content;

    public MyEvent(Object source) {
        super(source);
    }

    public MyEvent(Object source, String receiver, String content) {
        super(source);
        this.receiver = receiver;
        this.content = content;
    }

    public void output(){
        System.out.println("I had been sand a msg to " + this.receiver);
    }
}
