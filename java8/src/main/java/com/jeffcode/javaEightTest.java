package com.jeffcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: jefflike
 * @create: 2019/4/23
 * @describe:
 */
public class javaEightTest {
    @Test
    public void TestLambda() {
        // 使用匿名内部类的排序方式
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        // 记住Lambda表达式的口诀，照抄小括号，写死右箭头，花括号里直接照搬,形参的类型可以省略
        Collections.sort(names, (String o1, String o2) -> {
            return o1.compareTo(o2);
        });

    }
}
