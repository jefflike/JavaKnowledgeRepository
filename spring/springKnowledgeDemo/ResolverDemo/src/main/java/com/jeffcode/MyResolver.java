package com.jeffcode;

import org.springframework.core.io.*;

/**
 * @Author: jefflike
 * @create: 2019/3/28
 * @describe:
 */
public class MyResolver implements ProtocolResolver {
    public Resource resolve(String s, ResourceLoader resourceLoader) {
        return new ClassPathResource(s,resourceLoader.getClassLoader());
//        return new FileSystemResource(s);
    }
}
