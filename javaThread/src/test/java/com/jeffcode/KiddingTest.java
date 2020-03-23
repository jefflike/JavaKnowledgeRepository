package com.jeffcode;

import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class KiddingTest {
/*    private KiddingTest() {

    }*/

    // volatile防止getInstance内指令重排序
    private static volatile KiddingTest kiddingTest;

    public static KiddingTest getInstance() {
        if (kiddingTest == null) {
            synchronized (KiddingTest.class) {
                if (kiddingTest == null) {
                    kiddingTest =  new KiddingTest();
                }
            }
        }
        return kiddingTest;
    }
    @Test
    public void 单例测试 () {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 20; i++) {
            executorService.submit(new Runnable() {
                public void run() {
                    System.out.println(Thread.currentThread().getName()+ KiddingTest.getInstance());
                }
            });
        }
        executorService.shutdown();
    }
}
