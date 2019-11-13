package com.jeffcode;

public class AnonymousThread {

    public static void main(String[] args) {
/*        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(i + "当前线程是" + Thread.currentThread());
                }

            }
        }.start();*/
        new Thread(new Runnable() {
            public void run() {
                System.out.println("Runnable");
            }
        }) {
            @Override
            public void run() {
                System.out.println("Thread");
            }
        }.start();
    }
}
