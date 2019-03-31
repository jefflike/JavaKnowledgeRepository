package com.jeffcode;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

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
