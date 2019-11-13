package com.jeffcode;

public class ImplementsRunnable implements Runnable {

    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i + "当前线程是" + Thread.currentThread());
        }

    }

    public static void main(String[] args) {
        ImplementsRunnable implementsRunnable = new ImplementsRunnable();
        ImplementsRunnable implementsRunnable1 = new ImplementsRunnable();
        ImplementsRunnable implementsRunnable2 = new ImplementsRunnable();

        Thread thread1 = new Thread(implementsRunnable, "线程0");
        Thread thread2 = new Thread(implementsRunnable1, "线程1");
        Thread thread3 = new Thread(implementsRunnable2, "线程2");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
