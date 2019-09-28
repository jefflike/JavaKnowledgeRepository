package com.jefflike.config;

import com.jefflike.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NBConfig {

    @Bean
    public Person Person () {
        return new Person("jefflike", "333");
    }
}
