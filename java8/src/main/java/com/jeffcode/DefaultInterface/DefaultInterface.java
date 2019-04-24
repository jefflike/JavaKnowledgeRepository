package com.jeffcode.DefaultInterface;

/**
 * @Author: jefflike
 * @create: 2019/4/23
 * @describe:
 */
public interface DefaultInterface {

    void Jeff();

    // 非抽象的方法，可扩展实现类的可以直接使用此方法,注意，不可被实现类覆写
    default void  PrintName(String name) {
        System.out.println("name is " + name);
    }
}
