package com.jeffcode;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static void main(String[] args) {
        // 固定数量的连接
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i <100 ; i++) {
            executorService.submit(new Runnable() {
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
        executorService.shutdown();

        // 动态数量的连接
        ExecutorService executorService1 = Executors.newCachedThreadPool();
        for (int i = 0; i <100 ; i++) {
            executorService1.submit(new Runnable() {
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
        executorService1.shutdown();

        // 单个数量的连接
        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
        for (int i = 0; i <100 ; i++) {
            executorService2.submit(new Runnable() {
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
        executorService2.shutdown();
    }
}
