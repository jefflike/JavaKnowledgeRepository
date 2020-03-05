package com.jeffcode;

public class staticSequenceDemo {
    private static int value;

    public static int getSequence() {
        synchronized (staticSequenceDemo.class) {
            value ++;
        }
       return value ;
    }

    public static void main(String[] args) {

        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + " " + staticSequenceDemo.getSequence());
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
                    System.out.println(Thread.currentThread().getName() + " " + staticSequenceDemo.getSequence());
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
                    System.out.println(Thread.currentThread().getName() + " " + staticSequenceDemo.getSequence());
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
