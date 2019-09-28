package com.jefflike.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
//@AllArgsConstructor
public class Person {
    private String name;

    private String age;

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }
}
