package com.jeffcode;

import org.junit.Test;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: jefflike
 * @create: 2019/3/31
 * @describe:
 */
public class MyFactoryBeanTest {
    @Test
    public void MyFactoryBeanTest() {
        ClassPathXmlApplicationContext cac = new ClassPathXmlApplicationContext("applicationContext.xml");
/*        Person jefflike = cac.getBean(Person.class);
        jefflike.setName("jeff");
        System.out.println(jefflike.toString());*/

        MyFactoryBean bean = cac.getBean(MyFactoryBean.class);
        Class<?> objectType = bean.getObjectType();
        // 获取到的还是Person对象，而不是我们期待的MyFactoryBean对象
        System.out.println(objectType);

        // 那么我们想获得原始的factorybean那该怎么办呢？
        Object bean1 = cac.getBean("&myFactoryBean");
        System.out.println(bean1);
    }
}
