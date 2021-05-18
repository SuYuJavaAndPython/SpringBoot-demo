package com.xingyu;

import com.xingyu.config.FoodConfig;
import com.xingyu.config.VegetablesConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * @EnableConfigurationProperties({FoodConfig.class})
 * 告知主程序入口类  要自动引入配置文件  配置文件对应的类作为他的参数
 */
@SpringBootApplication
@EnableConfigurationProperties({FoodConfig.class})
public class MainApplication {

    public static void main(String[] args) {
        /**
         * 修改配置的两种方式：
         *      1. application.yml
         *      2. 写一个配置类，添加一个叫customizer的bean，然后重写customize方法
         */
        SpringApplication.run(MainApplication.class, args);
    }

    /**
     * 响应式编程的demo
     * @return
     */
    @Bean
    public RouterFunction<ServerResponse> hello(){
        return route(GET("/hello"),
                serverRequest -> ok().body(Mono.just("Hello World"),String.class));
    }

}
