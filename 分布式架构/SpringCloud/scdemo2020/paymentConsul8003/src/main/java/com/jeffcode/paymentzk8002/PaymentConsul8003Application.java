package com.jeffcode.paymentzk8002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentConsul8003Application {

    public static void main(String[] args) {
        SpringApplication.run(PaymentConsul8003Application.class, args);
    }

}
