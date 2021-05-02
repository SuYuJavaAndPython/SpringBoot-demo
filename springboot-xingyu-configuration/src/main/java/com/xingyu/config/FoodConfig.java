package com.xingyu.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ConfigurationProperties(prefix = "food")
 * 声明这是一个配置文件对应的类
 * prefix前缀指向配置文件中的一级目录(即前缀)
 */
@ConfigurationProperties(prefix = "food")
@Getter
@Setter
public class FoodConfig {

    private String ice;
    private String price;
    private String[] tastes;
}
