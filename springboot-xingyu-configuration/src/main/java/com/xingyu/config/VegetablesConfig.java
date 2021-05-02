package com.xingyu.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Configuration
 * 声明这是一个配置类    在spring中可以替代xml文件
 * @ConfigurationProperties(prefix = "vegetables")
 * 声明配置文件类  并说明前缀
 * @PropertySource("classpath:vegetables.properties")
 * 该配置文件类中的属性值去该路径下寻找xxx.properties文件中的键值对 对应赋值
 */
@Configuration
@ConfigurationProperties(prefix = "vegetables")
@PropertySource("classpath:vegetables.properties")
@Getter
@Setter
public class VegetablesConfig {

    private String potato;
    private String eggplant;
    private String greenPepper;
}
