package com.jeffcode.scdemo.scdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients("com.jeffcode.scdemo.scdemo.service")
public class ScdemoProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScdemoProviderApplication.class, args);
    }

}
