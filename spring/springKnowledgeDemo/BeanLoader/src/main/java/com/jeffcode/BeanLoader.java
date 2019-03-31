package com.jeffcode;

import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

/**
 * @Author: jefflike
 * @create: 2019/3/28
 * @describe:
 */
public class BeanLoader {
    @Test
    public void BeanLoaderTest() {
        // 获取类路径下的bean的xml文件资源
        ClassPathResource classPathResource = new ClassPathResource("jeff.xml");
        // 获取一个默认工厂（随便使用一个基本实现功能的工厂）
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        // 该Reader 对象为资源的解析器
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        // 解析，注册资源到ioc容器
        xmlBeanDefinitionReader.loadBeanDefinitions(classPathResource);
        // 被ioc容器管理后，我们就可以直接getBean获取xml中对象
        Person person = defaultListableBeanFactory.getBean("person", Person.class);
        // 获取到xml配置的jeff的Person对象
        System.out.println(person);
        }
}
