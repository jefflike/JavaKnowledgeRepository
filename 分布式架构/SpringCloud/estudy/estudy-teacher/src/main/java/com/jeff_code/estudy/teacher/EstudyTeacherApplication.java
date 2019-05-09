package com.jeff_code.estudy.teacher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableDiscoveryClient
@ServletComponentScan
@MapperScan(basePackages = "com.jeff_code.estudy.teacher.mapper")
@ComponentScan(basePackages = "com.jeff_code.estudy")
public class EstudyTeacherApplication {

    public static void main(String[] args) {
        SpringApplication.run(EstudyTeacherApplication.class, args);
    }
}
