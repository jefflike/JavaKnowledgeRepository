package com.jeffcode;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Author: jefflike
 * @create: 2019/3/27
 * @describe:
 */
public class classloaderDemoTest {
    @Test
    public void classloaderTest() {
        Properties properties = new Properties();
        // 获取当前线程类加载器
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        // 读取指定资源为流文件
        InputStream resourceAsStream = contextClassLoader.getResourceAsStream("jeff.properties");
        try {
            // 这里是properties，spring中是xml配置文件的资源加载
            properties.load(resourceAsStream);
            String jeff = properties.getProperty("jeff");
            System.out.println(jeff);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
