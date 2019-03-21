package com.jeff_code;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Proxy;

public class Test {

    @org.junit.Test
    public void testLife() {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
        Person person = ac.getBean("person", Person.class);
        person.sayHello();
        ac.close();
    }

    @org.junit.Test
    public void myProxy() {
        Man man = new Man();
        man.setName("jeff");

        SmallMan jefflike = (SmallMan) new MyProxy().getInstance(man);
//        jefflike.FindHouse();
    }

}
