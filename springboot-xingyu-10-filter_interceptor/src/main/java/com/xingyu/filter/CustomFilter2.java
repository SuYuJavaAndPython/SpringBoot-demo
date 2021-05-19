package com.xingyu.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @WebFilter(filterName = "customFilter2", urlPatterns = {"/*"})
 * 声明一个可被扫描到的Filter，通过入口类的@ServletComponentScan获取实例进行管理
 */
@WebFilter(filterName = "customFilter2", urlPatterns = {"/*"})
public class CustomFilter2 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("我是CustomFilter2的init方法");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("我是CustomFilter2的doFilter方法");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("我是CustomFilter2的destroy方法");
    }
}
