package com.jeffcode.DefaultInterface;

import org.junit.Test;

/**
 * @Author: jefflike
 * @create: 2019/4/23
 * @describe:
 */
public class UseDefaultInterface implements DefaultInterface {
    // 实现接口可直接使用扩展方法，而不需要自己写此打印方法
    public void Jeff() {
        PrintName("jefflike");
    }
}


