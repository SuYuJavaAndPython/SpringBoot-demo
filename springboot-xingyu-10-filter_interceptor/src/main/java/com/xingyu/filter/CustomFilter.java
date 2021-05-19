package com.xingyu.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 注意此Filter虽然已经被声明，但不被servlet容器，也不被spring管理
 * 以前管理我们写的Filter是通过web.xml文件配置，配置信息如下：
 * <filter>
 *     <filter-name>struts2</filter-name>
 *     <filter-class>com.xingyu.filter.CustomFilter</filter-class>
 * </filter>
 * <filter-mapping>
 *     <filter-name>struts2</filter-name>
 *     <url-pattern>/*</url-pattern>
 * </filter-mapping>
 */
public class CustomFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("我是CustomFilter的init方法");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("我是CustomFilter的doFilter方法");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("我是CustomFilter的destroy方法");
    }
}
