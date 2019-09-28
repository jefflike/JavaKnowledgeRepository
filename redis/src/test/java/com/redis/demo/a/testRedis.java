package com.redis.demo.a;

import org.junit.Test;
import redis.clients.jedis.Jedis;

public class testRedis {
    @Test
    public void testRedis () {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("192.168.10.128", 6379);
        System.out.println("连接成功");
        //设置 redis 字符串数据
        jedis.set("runoobkey", "www.runoob.com");
        // 获取存储的数据并输出
        System.out.println("redis 存储的字符串为: "+ jedis.get("runoobkey"));
    }

}
