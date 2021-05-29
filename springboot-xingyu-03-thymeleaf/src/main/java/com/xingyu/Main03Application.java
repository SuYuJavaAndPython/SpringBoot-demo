package com.xingyu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main03Application {

    /**
     * jsp不是不能用，只是不推荐。在内嵌容器中无法使用，只能打包war包，
     * 然后部署在外部容器中,jar包内嵌Tomcat容器由于和jsp相关api的名称重复，
     * 故而无法兼容jsp
     *    <!-- war格式打包时排除内置的tomcat -->
     *       <dependency>
     *             <groupId>org.springframework.boot</groupId>
     *             <artifactId>spring-boot-starter-tomcat</artifactId>
     *             <scope>provided</scope>
     *        </dependency>
     *         <!--用于编译jsp的依赖 provided为打包时排除，外部tomcat提供-->
     *         <dependency>
     *             <groupId>org.apache.tomcat.embed</groupId>
     *             <artifactId>tomcat-embed-jasper</artifactId>
     *             <scope>provided</scope>
     *         </dependency>
     *         <!-- servlet-api和jsp.api外部tomcat提供，打包无需添加-->
     *          <!--添加相关jstl标签库依赖-->
     *         <dependency>
     *             <groupId>javax.servlet</groupId>
     *             <artifactId>jstl</artifactId>
     *         </dependency>
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(Main03Application.class, args);
    }

}
