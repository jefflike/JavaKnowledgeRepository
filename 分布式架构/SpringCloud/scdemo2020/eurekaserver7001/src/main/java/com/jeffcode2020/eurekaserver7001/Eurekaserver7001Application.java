package com.jeffcode2020.eurekaserver7001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Eurekaserver7001Application {

    public static void main(String[] args) {
        SpringApplication.run(Eurekaserver7001Application.class, args);
    }

}
