package com.jeffcode;

import org.springframework.context.ApplicationListener;

/**
 * @Author: jefflike
 * @create: 2019/5/7
 * @describe:
 */
public class MyListener implements ApplicationListener<MyEvent> {

    public void onApplicationEvent(MyEvent myEvent) {
        myEvent.output();
        System.out.println(myEvent.receiver + " MsgListener msg : " + myEvent.content );
    }
}
