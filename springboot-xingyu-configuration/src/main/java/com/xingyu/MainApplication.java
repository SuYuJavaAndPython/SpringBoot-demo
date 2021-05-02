package com.xingyu;

import com.xingyu.config.FoodConfig;
import com.xingyu.config.VegetablesConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Profile;

/**
 * @EnableConfigurationProperties({FoodConfig.class})
 * 告知主程序入口类  要自动引入配置文件  配置文件对应的类作为他的参数
 */
@SpringBootApplication
@EnableConfigurationProperties({FoodConfig.class})
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }
}
