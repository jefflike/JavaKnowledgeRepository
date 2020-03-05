package com.jeffcode;

import java.util.concurrent.atomic.AtomicInteger;

public class atomicTest {
    private AtomicInteger value = new AtomicInteger(0);

    public int getSequence() {
        return value.getAndIncrement() ;
    }

    public static void main(String[] args) {
        final atomicTest atomicTest = new atomicTest();

        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + " " + atomicTest.getSequence());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + " " + atomicTest.getSequence());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + " " + atomicTest.getSequence());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();
    }
}
