package com.jeffcode;

public class extendThread extends Thread{

    // 继承Thread类启动多线程后会默认执行run方法
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i + "当前线程是" + Thread.currentThread());
        }

    }

    public static void main(String[] args) throws InterruptedException {
        extendThread extendWay = new extendThread();
        extendThread extendWay1 = new extendThread();
        extendThread extendWay2 = new extendThread();

        extendWay.start();
        extendWay1.start();
        extendWay2.start();
    }
}

