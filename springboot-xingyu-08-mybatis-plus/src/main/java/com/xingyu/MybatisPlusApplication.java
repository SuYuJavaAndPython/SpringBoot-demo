package com.xingyu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xingyu.mapper")
public class MybatisPlusApplication {

    public static void main(String[] args) {
        //mybatis-plus简化单表crud操作的三种方式：
        //1.GuestServiceImpl extends ServiceImpl<GuestMapper,Guest>
        //2.interface GuestService extends IService<Guest>
        //3.interface GuestMapper extends BaseMapper<Guest>
        SpringApplication.run(MybatisPlusApplication.class, args);
    }

}
