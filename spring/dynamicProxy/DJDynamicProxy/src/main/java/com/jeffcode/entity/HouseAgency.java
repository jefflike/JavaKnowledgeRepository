package com.jeffcode.entity;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: jefflike
 * @create: 2019/3/23
 * @describe:
 * 代理类，继承了自定义DJInvocationHandler
 */
public class HouseAgency implements DJInvocationHandler {
    // 被代理对象
    private Object target;

    public Object getInstance(Object target) {
        this.target = target;
        Class<?>[] interfaces = target.getClass().getInterfaces();
        return DJProxy.newProxyInstance(new DJClassLoader(), interfaces, this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        System.out.println("this is proxy,can i help you");
        // 调用代理对象的方法
        try {
            method.invoke(target, args);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
