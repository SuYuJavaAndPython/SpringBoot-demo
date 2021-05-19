package com.xingyu.config;

import com.xingyu.filter.CustomFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    /**
     * FilterRegistrationBean
     * 管理filter的注册
     * @return
     */
    @Bean
    public FilterRegistrationBean<CustomFilter> filterRegistrationBean(){
        FilterRegistrationBean<CustomFilter> filterRegistrationBean =  new FilterRegistrationBean<>();
        //添加我们写的CustomFilter
        filterRegistrationBean.setFilter(new CustomFilter());
        //添加过滤路径
        filterRegistrationBean.addUrlPatterns("/*");
        //设置注册优先级 int（值越小优先级越高）
//        filterRegistrationBean.setOrder(100);
        return filterRegistrationBean;
    }

}
