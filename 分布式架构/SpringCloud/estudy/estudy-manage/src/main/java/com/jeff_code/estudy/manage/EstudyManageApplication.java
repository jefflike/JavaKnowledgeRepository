package com.jeff_code.estudy.manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@ServletComponentScan
@ComponentScan(basePackages = "com.jeff_code.estudy")
public class EstudyManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(EstudyManageApplication.class, args);
    }
}
