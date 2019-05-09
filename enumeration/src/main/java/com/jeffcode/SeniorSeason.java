package com.jeffcode;

/**
 * @Author: jefflike
 * @create: 2019/4/24
 * @describe:
 * 高级一点的玩法
 */
public enum SeniorSeason {
    SPRING(1, "春天", "春天万物复苏") {
        public SeniorSeason getNext() {
            return SUMMER;
        }
    },
    SUMMER(2, "夏天", "夏天热死个人") {
        public SeniorSeason getNext() {
            return AUTUMN;
        }
    },
    AUTUMN(3, "秋天", "秋天秋高气爽") {
        public SeniorSeason getNext() {
            return WINTER;
        }
    },
    WINTER(4, "冬天", "冬天暴雪爱爱") {
        public SeniorSeason getNext() {
            return SPRING;
        }
    };

    SeniorSeason(int a, String name, String desc) {
        this.a = a;
        this.name = name;
        this.desc = desc;
    }

    private int a;
    private String name;
    private String desc;
    // 此处需要提供公共的抽象方法
    public abstract SeniorSeason getNext();

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
