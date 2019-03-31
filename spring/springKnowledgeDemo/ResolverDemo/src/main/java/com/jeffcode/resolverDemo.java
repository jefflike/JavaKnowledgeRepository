package com.jeffcode;

import org.junit.Test;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.ProtocolResolver;
import org.springframework.core.io.Resource;

/**
 * @Author: jefflike
 * @create: 2019/3/27
 * @describe:
 */
public class resolverDemo {
    @Test
    public void resolverTest() {
        DefaultResourceLoader defaultResourceLoader = new DefaultResourceLoader();
        defaultResourceLoader.addProtocolResolver(new MyResolver());
        Resource fileResource1 = defaultResourceLoader.getResource("D:/spark.txt");
        System.out.println("fileResource1 is FileSystemResource:" + (fileResource1 instanceof FileSystemResource));
    }
}
