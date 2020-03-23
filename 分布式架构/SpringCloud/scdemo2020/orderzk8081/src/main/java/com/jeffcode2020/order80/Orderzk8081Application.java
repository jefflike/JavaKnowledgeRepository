package com.jeffcode2020.order80;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class Orderzk8081Application {

    public static void main(String[] args) {
/*        String name = EnableAutoConfiguration.class.getName();
        log.info("启动了：" + name);*/
        SpringApplication.run(Orderzk8081Application.class, args);
    }

}
