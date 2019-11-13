package com.jeffcode;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

// 指定返回的类型
public class ImplementsCallable implements Callable<Integer> {
    public Integer call() throws Exception {
        System.out.println("执行很多操作");
        Thread.sleep(10000);
        return 1;
    }

    public static void main(String[] args)throws Exception {
        Callable<Integer> implementsCallable = new ImplementsCallable();
        FutureTask<Integer> integerFutureTask = new FutureTask<Integer>(implementsCallable);
        Thread thread = new Thread(integerFutureTask);
        thread.start();
        System.out.println("正常业务执行");
        Thread.sleep(8000);
        System.out.println("执行结果为：" + integerFutureTask.get());

    }
}
