package com.jeffcode.FunctionInterface;

/**
 * @Author: jefflike
 * @create: 2019/4/24
 * @describe:
 * 定义一个函数式接口,FunctionalInterface可以省略
 */
//@FunctionalInterface
public interface FunctionInterface<T, E> {
    T convert(E e);
}
