package com.jefflike;

/**
 * @Author: jefflike
 * @create: 2019/5/4
 * @describe: 事件源
 */
public interface IEvent {

    void setIlistener(Ilistener ilistener);

    boolean ClickButton();

    boolean MoveMouse();


}
