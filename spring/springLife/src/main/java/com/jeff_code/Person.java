package com.jeff_code;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Person implements BeanNameAware, ApplicationContextAware, InitializingBean, DisposableBean {
    private String name;

    public Person() {
        System.out.println("1.构造器创建类");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("2.set参数");
        this.name = name;
    }

    public void init() {
        System.out.println("7. 初始化方法");
    }

    public void destory() {
        System.out.println("11.全部结束整个销毁方法");
    }


    @Override
    public void setBeanName(String s) {
        System.out.println("3.将xml配置中的id/name的名字得到");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("4.让我们的类了解工厂信息了");
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("6. 属性设置后执行");
    }

    public void sayHello() {
        System.out.println("9. 如果调用了它的方法才会执行到这个生命周期,"+ name);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("10. Spring的一个销毁方法");
    }
}
