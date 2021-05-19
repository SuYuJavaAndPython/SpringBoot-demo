package com.xingyu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan("com.xingyu.filter")
public class FilterAndInterceptorApplication {

    public static void main(String[] args) {
        SpringApplication.run(FilterAndInterceptorApplication.class, args);
    }

}
