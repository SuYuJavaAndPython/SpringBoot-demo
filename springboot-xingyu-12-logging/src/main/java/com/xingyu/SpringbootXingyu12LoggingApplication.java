package com.xingyu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootXingyu12LoggingApplication {

    /**
     * %d表示日期时间，
     *         %thread表示线程名，
     *         %-5level：级别从左显示5个字符宽度
     *         %logger{50} 表示logger名字最长50个字符，否则按照句点分割。 
     *         %msg：日志消息，
     *         %n是换行符
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringbootXingyu12LoggingApplication.class, args);
    }

}
