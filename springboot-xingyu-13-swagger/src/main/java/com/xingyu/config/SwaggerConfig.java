package com.xingyu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @EnableSwagger2 声明此配置类能够使用swagger2
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * 使用swagger需要创建一个摘要 Docket
     * 摘要参数如下：
     *      文档类型 - 使用swagger2 - DocumentationType.SWAGGER_2
     *      文档通过一系列的选择器组成 api path
     *      select()返回一个ApiSelectorBuilder实例,用来控制哪些接口暴露给Swagger来展现
     *      apis 查找生成哪些controller的接口说明
     *          RequestHandlerSelectors.any()表示所有带controller注解的接口（包括默认的Error）
     *          也可RequestHandlerSelectors.basePackage("com.xingyu.controller")进行指定
     *      paths 在查找出来的接口中进行筛选
     * @return
     */
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    /**
     * 创建该API的基本信息（这些基本信息会展现在文档页面中）
     * 访问地址：http://项目实际地址/swagger-ui.html
     * @return
     */
    public ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful APIs")
                .description("这是一个简单的swagger2 demo")
                .termsOfServiceUrl("http://www.baidu.com")
                .contact(new Contact("小陈","http://www.baidu.com","123456789@qq.com"))
                .version("1.0")
                .build();
    }
}
