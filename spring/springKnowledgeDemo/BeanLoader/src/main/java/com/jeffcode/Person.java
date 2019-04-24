package com.jeffcode;

public class Person {
    private String name;

    public Person() {
        System.out.println("构造器创建类");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("set参数");
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
