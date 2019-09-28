package com.jefflike.config;

import com.jefflike.bean.Person;
import com.jefflike.condition.linuxCondition;
import com.jefflike.condition.winCodition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OsConfig {

    @Bean
    @Conditional(winCodition.class)
    public Person personWin () {
        return new Person("win10", null);
    }

    @Bean
    @Conditional(linuxCondition.class)
    public Person personLinux () {
        return new Person("Linux", null);
    }
}
