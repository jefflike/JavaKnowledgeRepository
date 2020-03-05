package com.jeffcode.scdemo.scdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class RegisterCenter3Application {

    public static void main(String[] args) {
        SpringApplication.run(RegisterCenter3Application.class, args);
    }

}
