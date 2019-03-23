package com.jeffcode.entity;

import java.lang.reflect.Method;

/**
 * @Author: jefflike
 * @create: 2019/3/23
 * @describe:
 */
public interface DJInvocationHandler {
    Object invoke(Object proxy, Method method, Object[] args);
}
