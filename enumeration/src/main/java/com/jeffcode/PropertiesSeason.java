package com.jeffcode;

/**
 * @Author: jefflike
 * @create: 2019/4/24
 * @describe:
 * 带有自定义属性的枚举类
 */
public enum PropertiesSeason {
    SPRING(1, "春天", "春天万物复苏"),
    SUMMER(2, "夏天", "夏天热死个人"),
    AUTUMN(3, "秋天", "秋天秋高气爽"),
    WINTER(4, "冬天", "冬天暴雪爱爱");

    // 构造函数只会在构造枚举值的时候被调用
    PropertiesSeason(int a, String name, String desc) {
        this.a = a;
        this.name = name;
        this.desc = desc;
    }

    private int a;
    private String name;
    private String desc;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
