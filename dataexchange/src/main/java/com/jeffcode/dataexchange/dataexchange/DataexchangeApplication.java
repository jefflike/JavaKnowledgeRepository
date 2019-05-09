package com.jeffcode.dataexchange.dataexchange;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DataexchangeApplication {
    // 表面上获取一个slf4j的logger对象
    public static final Logger logger = LoggerFactory.getLogger(DataexchangeApplication.class);

    public static void main(String[] args) {
        java.security.Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        SpringApplication.run(DataexchangeApplication.class, args);

    }

    @Bean("jefflike")
    public StartUpListener startUpListener() {
        return new StartUpListener();
    }

}
