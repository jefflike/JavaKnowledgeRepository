package com.redis.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// @Configuration spring3.0中的xml
@Configuration
public class RedisConfig {
    // host，port，database 三个属性值放入application.properties 中
    //读取配置文件中的redis的ip地址
    // :disabled 默认值，如果host为空，则host=disabled
    @Value("${spring.redis.host:disabled}")
    private String host;

    @Value("${spring.redis.port:0}")
    private int port;

    @Value("${spring.redis.database:0}")
    private int database;

    // <bean class="RedisUtil"></bean>
    @Bean
    public RedisUtil getRedisUtil(){
        if ("disabled".equals(host)){
            return null;
        }
        RedisUtil redisUtil = new RedisUtil();
        redisUtil.initJedisPool(host,port,database);
        return redisUtil;
    }









}
