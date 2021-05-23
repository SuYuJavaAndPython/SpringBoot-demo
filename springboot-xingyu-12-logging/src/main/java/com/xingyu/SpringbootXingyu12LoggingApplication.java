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
     * 现在流行的日志框架搭配是 slf4j日志框架门面 + logback
     * 想要使用log4j12：先移除logback和log4j，再加入log4j12
     *          <dependency>
     *             <groupId>org.springframework.boot</groupId>
     *             <artifactId>spring-boot-starter-web</artifactId>
     *             <exclusions>
     *                 <exclusion>
     *                     <artifactId>logback-classic</artifactId>
     *                     <groupId>ch.qos.logback</groupId>
     *                 </exclusion>
     *                 <exclusion>
     *                     <artifactId>log4j-to-slf4j</artifactId>
     *                     <groupId>org.apache.logging.log4j</groupId>
     *                 </exclusion>
     *             </exclusions>
     *          </dependency>
     *
     *         <dependency>
     *             <groupId>org.slf4j</groupId>
     *             <artifactId>slf4j-log4j12</artifactId>
     *         </dependency>
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringbootXingyu12LoggingApplication.class, args);
    }

}
