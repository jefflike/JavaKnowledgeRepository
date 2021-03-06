package com.jeffcode2020.order80;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@Slf4j
@EnableFeignClients
public class OrderOpenFeign8083Application {

    public static void main(String[] args) {
        SpringApplication.run(OrderOpenFeign8083Application.class, args);
    }

}
