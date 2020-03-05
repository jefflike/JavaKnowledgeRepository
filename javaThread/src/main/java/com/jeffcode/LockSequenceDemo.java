package com.jeffcode;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockSequenceDemo {
    private int value;

    public Lock lock = new ReentrantLock();

    public int getSequence() {
        lock.lock();
        int i = value++;
        lock.unlock();
        return i ;
    }

    public static void main(String[] args) {
        final LockSequenceDemo sequenceDemo = new LockSequenceDemo();

/*        while (true) {
            sequenceDemo.getSequence();
        }*/

        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + " " + sequenceDemo.getSequence());
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
                    System.out.println(Thread.currentThread().getName() + " " + sequenceDemo.getSequence());
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
                    System.out.println(Thread.currentThread().getName() + " " + sequenceDemo.getSequence());
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
