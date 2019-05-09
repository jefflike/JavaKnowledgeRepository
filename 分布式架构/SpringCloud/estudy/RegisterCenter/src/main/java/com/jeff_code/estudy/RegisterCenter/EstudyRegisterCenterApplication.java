package com.jeff_code.estudy.RegisterCenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EstudyRegisterCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(EstudyRegisterCenterApplication.class, args);
    }
}
