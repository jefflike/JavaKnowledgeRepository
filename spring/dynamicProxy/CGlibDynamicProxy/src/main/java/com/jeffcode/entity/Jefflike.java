package com.jeffcode.entity;

/**
 * @Author: Jefflike
 * @create: 2019/3/21
 * @describe:
 * 提供一个被代理对象jefflike
 */
public class Jefflike{
    private String name;

    public Jefflike() {

    }

    public Jefflike(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void findHouse() {
        System.out.println("my name is " + name);
        System.out.println("i need find a house!");
    }
}
