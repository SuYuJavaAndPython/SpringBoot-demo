package com.xingyu.customizer;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@Configuration
public class MyCustomizer {

    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> customizer(){
        return factory -> {
            ErrorPage errorPage = new ErrorPage(HttpStatus.NOT_FOUND, "/myError404");
            factory.addErrorPages(errorPage);
        };
    }
}
