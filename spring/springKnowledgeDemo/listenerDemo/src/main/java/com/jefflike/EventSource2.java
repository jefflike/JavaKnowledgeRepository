package com.jefflike;

/**
 * @Author: jefflike
 * @create: 2019/5/5
 * @describe:
 */
public class EventSource2 implements IEvent {
    private Ilistener ilistener;
    private boolean button;
    private boolean mouse;

    public void setIlistener(Ilistener ilistener) {
        this.ilistener = ilistener;
    }

    public boolean ClickButton() {
        return button;
    }

    public boolean MoveMouse() {
        return mouse;
    }

    public void buttonEventHappened() {
        mouse = true;
        ilistener.doEvent(this);
    }
}