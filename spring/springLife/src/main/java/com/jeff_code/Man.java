package com.jeff_code;

import java.io.Serializable;

/**
 * @Author: jefflike
 * @create: 2019/3/18
 * @describe:
 */
public class Man implements SmallMan {
    private String name;

    public Man() {
    }

    public Man(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void FindHouse(){
        System.out.println("i need a house!");
    }
}
