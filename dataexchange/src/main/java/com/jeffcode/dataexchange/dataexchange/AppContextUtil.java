package com.jeffcode.dataexchange.dataexchange;

import org.springframework.context.ApplicationContext;


public class AppContextUtil {
	
	private static ApplicationContext ctx = null;
	
	public static ApplicationContext getSpringApplicationContext() {
		return ctx;
	}

	public static boolean containsBean(String bean) {
		return ctx.containsBean(bean);
	}

	public static Object getBean(String name) {
		return ctx.getBean(name);
	}
	
	public static Object getBean(String name, Class<?> requiredType) {
		return ctx.getBean(name, requiredType);
	}

	public static Object getBean(Class<?> requiredType) {
		return ctx.getBean(requiredType);
	}
}
