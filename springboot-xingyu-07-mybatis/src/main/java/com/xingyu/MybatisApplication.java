package com.xingyu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @MapperScan("com.xingyu.mapper")
 * 当mapper包下的接口过多时，每一个接口都需要加上@Mapper注解，容易忘，此注解可以代替该包下所有的@Mapper
 */
@SpringBootApplication
//@MapperScan("com.xingyu.mapper")  //org包下的
@MapperScan("com.xingyu.tk.mapper") //tk包下的
public class MybatisApplication {
    public static void main(String[] args) {
        SpringApplication.run(MybatisApplication.class, args);
    }
}
