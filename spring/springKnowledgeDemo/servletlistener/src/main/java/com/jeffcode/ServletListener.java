package com.jeffcode;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @Author: jefflike
 * @create: 2019/5/5
 * @describe:
 */
public class ServletListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContext启动初始化");
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContext关闭销毁");
    }
}
