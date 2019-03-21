package com.jeff_code;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: jefflike
 * @create: 2019/3/18
 * @describe:
 * 代理列需要实现InvocationHandler
 */
public class MyProxy implements InvocationHandler {

    private Man target;

    public Object getInstance(Man target) {
        this.target = target;
        ClassLoader classLoader = target.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        // 被代理人就是this，即当前中介就是h，代理对象
        return Proxy.newProxyInstance(classLoader, interfaces,this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(this.target.getName()+",您好，由我来给你找房子");
        this.target.FindHouse();
        return null;
    }
}
