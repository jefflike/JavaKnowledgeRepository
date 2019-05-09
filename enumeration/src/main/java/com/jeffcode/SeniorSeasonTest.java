package com.jeffcode;

import org.junit.Test;

/**
 * @Author: jefflike
 * @create: 2019/4/24
 * @describe:
 */
public class SeniorSeasonTest {
    SeniorSeason seniorSeason = SeniorSeason.AUTUMN;

    @Test
    public void EnumTest() {
        switch (seniorSeason) {
            case SPRING:
                System.out.println(seniorSeason.SPRING.getDesc() + "next season is" + seniorSeason.getNext().getName());
            case SUMMER:
                System.out.println(seniorSeason.SUMMER.getDesc() + "next season is" + seniorSeason.getNext().getName());
            case AUTUMN:
                System.out.println(seniorSeason.AUTUMN.getDesc() + "next season is" + seniorSeason.getNext().getName());
            case WINTER:
                System.out.println(seniorSeason.WINTER.getDesc() + "next season is" + seniorSeason.getNext().getName());
        }

        // 所在枚举的位置 2
        System.out.println(seniorSeason.ordinal());

        // 下标相差几 2
        System.out.println(seniorSeason.compareTo(SeniorSeason.SPRING));

        // 转换成string AUTUMN
        System.out.println(seniorSeason.toString());

        // 返回枚举值常量
        System.out.println(SeniorSeason.valueOf("SPRING"));

        // 返回一个包含全部枚举值的数组
        SeniorSeason[] seasons = SeniorSeason.values();
    }
}
