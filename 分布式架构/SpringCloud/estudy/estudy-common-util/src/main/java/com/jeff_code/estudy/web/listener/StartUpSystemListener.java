package com.jeff_code.estudy.web.listener;

import com.jeff_code.estudy.util.Const;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 监听器监听ServletContext对象的创建和销毁，将应用上下文路径放到页面显示,在使用模块下需要扫描当前的监听器
 */
//@WebServlet //声明Servlet对象
//@WebFilter //声明过滤器对象
@WebListener  //声明监听器对象,需要设置扫描注解@ServletComponentScan
public class StartUpSystemListener implements ServletContextListener {

	//如果ServletContext对象被创建，将上下文路径存放application域中。给JSP使用 ${pageContext.request.contextPath}   ${APP_PATH}
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext application = sce.getServletContext();
		String contextPath = application.getContextPath(); //应用上下文路径
		//  URL　=>　　http://localhost:8080/atcrowdfunding-main/index.jsp
		//  协议：  http://
		//  IP地址： localhost
		//  端口号： 8080
		//  上下文路径(一般是和项目名称一样的。可以修改。)： /atcrowdfunding-main
		//  url-pattern  : /index.jsp
		//  URI :   /atcrowdfunding-main/index.jsp
		application.setAttribute(Const.APP_PATH, contextPath);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

}
