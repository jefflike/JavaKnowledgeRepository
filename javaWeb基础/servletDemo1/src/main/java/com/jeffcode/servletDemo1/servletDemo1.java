package com.jeffcode.servletDemo1;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: jefflike
 * @create: 2019/2/26
 * @describe:
 */
public class servletDemo1 implements Servlet {
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        PrintWriter out = servletResponse.getWriter();
        out.println("hello jefflike");
        out.close();
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
