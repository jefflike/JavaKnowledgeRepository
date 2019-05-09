package com.jeffcode;

import org.junit.Test;

/**
 * @Author: jefflike
 * @create: 2019/4/24
 * @describe:
 * 枚举可自定义属性
 */
public class PropertiesSeasonTest {
    PropertiesSeason propertiesSeason = PropertiesSeason.AUTUMN;

    public PropertiesSeasonTest() {}
    @Test
    public void EnumTest() {
        switch (propertiesSeason) {
            case SPRING:
                System.out.println(PropertiesSeason.SPRING.getDesc());
            case SUMMER:
                System.out.println(PropertiesSeason.SUMMER.getDesc());
            case AUTUMN:
                System.out.println(PropertiesSeason.AUTUMN.getDesc());
            case WINTER:
                System.out.println(PropertiesSeason.WINTER.getDesc());
        }
    }
}
