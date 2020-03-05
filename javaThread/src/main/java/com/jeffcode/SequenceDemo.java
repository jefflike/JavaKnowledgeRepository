package com.jeffcode;

public class SequenceDemo {
    private int value;

    public int getSequence() {
       return value ++ ;
    }

    public static void main(String[] args) {
        final SequenceDemo sequenceDemo = new SequenceDemo();

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
