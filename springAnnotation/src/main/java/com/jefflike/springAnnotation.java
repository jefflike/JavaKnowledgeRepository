package com.jefflike;

import com.jefflike.bean.Person;
import com.jefflike.config.NBConfig;
import com.jefflike.config.OsConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

public class springAnnotation {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(NBConfig.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String name: beanDefinitionNames) {
            System.out.println(name);
        }

        String[] beanNamesForType = context.getBeanNamesForType(Person.class);
        for (String name: beanNamesForType) {
            System.out.println(name);
        }

    }
}
