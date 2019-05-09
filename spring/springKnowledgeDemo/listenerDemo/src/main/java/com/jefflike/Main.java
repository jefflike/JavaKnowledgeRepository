package com.jefflike;

/**
 * @Author: jefflike
 * @create: 2019/5/5
 * @describe:
 */
public class Main {
    public static void main(String[] args) {
        Ilistener listener = new Ilistener() {
            public void doEvent(IEvent iEvent) {
                if (iEvent.ClickButton() == true) {
                    System.out.println("点击按钮");
                } else if (iEvent.MoveMouse() == true) {
                    System.out.println("移动鼠标");
                } else {
                    System.out.println("暂时没操作");
                }
            }
        };

        // 创建一个事件源
        EventSource eventSource = new EventSource();
        // 绑定监听器
        eventSource.setIlistener(listener);
        // 触发事件
        eventSource.mouseEventHappened();
    }
}
