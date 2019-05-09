package com.jeffcode;

/**
 * @Author: jefflike
 * @create: 2019/5/4
 * @describe: 事件源：事件发生的地点
 */
public class EventSource {
    private IEventListener mEventListener;

    // 注册监听器
    public void setEventListener(IEventListener arg) {
        mEventListener = arg;
    }

    // 触发事件
    public void EventHappened() {
        mEventListener.onclickButton();
    }

    public static void main(String[] args) {
        // 事件源（被监听的对象）
        EventSource m1 = new EventSource();

        // 监听器
        IEventListener mEventListener = new IEventListener() {
            public void onclickButton() {
                System.out.println("你点击了按钮");
            }
        };

        // 注册监听器到事件源
        m1.setEventListener(mEventListener);
        m1.EventHappened();
    }
}
