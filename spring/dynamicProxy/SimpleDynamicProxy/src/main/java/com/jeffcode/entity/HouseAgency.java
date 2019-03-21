package com.jeffcode.entity;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: jefflike
 * @create: 2019/3/21
 * @describe:
 * 提供一个中介类，这个类需要实现jdk提供的，想要实现动态代理最简单就是直接实现它
 */
public class HouseAgency implements InvocationHandler {

    // 被代理对象
    private Object target;

    // 获取被代理对象
    public Object getInstance(Object target) {
        this.target = target;
        ClassLoader classLoader = target.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        // 调用代理方法获取代理对象
        return Proxy.newProxyInstance(classLoader, interfaces,this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("this is proxy,can i help you");
         // 调用代理对象的方法
        method.invoke(target,args);
        return null;
    }
}
