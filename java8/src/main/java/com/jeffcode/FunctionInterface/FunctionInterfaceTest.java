package com.jeffcode.FunctionInterface;

import org.junit.Test;

import java.util.function.Consumer;

/**
 * @Author: jefflike
 * @create: 2019/4/24
 * @describe:
 */
public class FunctionInterfaceTest {
    @Test
    public void FunctionInterfaceTest() {
        // 使用函数式接口
        FunctionInterface<Integer, String> t = (arg) -> Integer.valueOf(arg);
        Integer convert = t.convert("123");
        System.out.println(convert);
    }
}
