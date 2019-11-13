package com.jeffcode;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTaskDemo {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("定时任务");
            }
        }, 0, 1000);
    }
}
