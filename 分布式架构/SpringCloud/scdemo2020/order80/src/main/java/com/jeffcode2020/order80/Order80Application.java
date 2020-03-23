package com.jeffcode2020.order80;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@Slf4j
public class Order80Application {

    public static void main(String[] args) {
        String name = EnableAutoConfiguration.class.getName();
        log.info("启动了：" + name);
        SpringApplication.run(Order80Application.class, args);
    }

}
