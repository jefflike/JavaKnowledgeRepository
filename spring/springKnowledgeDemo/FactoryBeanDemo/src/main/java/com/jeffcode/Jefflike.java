package com.jeffcode;

/**
 * @Author: jefflike
 * @create: 2019/3/31
 * @describe:
 */
public class Jefflike implements Person {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "My name is :" + name;
    }
}
