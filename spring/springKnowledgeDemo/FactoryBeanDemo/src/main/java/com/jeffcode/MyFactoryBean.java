package com.jeffcode;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @Author: jefflike
 * @create: 2019/3/31
 * @describe:
 */
// 管理到ioc容器
@Component
public class MyFactoryBean implements FactoryBean {
    public Object getObject() throws Exception {
        return new Jefflike();
    }

    public Class<?> getObjectType() {
        return Person.class;
    }

    public boolean isSingleton() {
        return true;
    }
}
