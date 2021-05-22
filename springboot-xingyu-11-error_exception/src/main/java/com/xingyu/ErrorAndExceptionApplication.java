package com.xingyu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ErrorAndExceptionApplication {

    /**
     * 错误&异常处理机制：
     * 提供三种处理方式：数据验证错误，错误页指派，全局异常的处理
     * 前言：
     * JSR-303 是 JAVA EE 6 中的一项子规范，叫做 Bean Validation，官方参考实现是Hibernate Validator。 此
     * 实现与 Hibernate ORM 没有任何关系。 JSR 303 用于对 Java Bean 中的字段的值进行验证，是一个运行期
     * 的数据验证框架。
     * 在应用程序中，通过使用 Bean Validation 或是你自己定义的 constraint，就可以确保数据模型（JavaBean）
     * 的正确性
     *
     * 数据验证错误：
     *      1) 独立使用hibernate-validation 框架基于普通模式和快速失败模式
     *      2) 通过springboot集成hibernate-validation框架使用
     *         参数加@Valid用于校验bean 后加BindingResult类型参数自定义处理返回信息
     *         类似@NotBlank 中的注解信息message不建议写死，springboot提供读取默认的配置文件信息取代
     *         文件名ValidationMessages.properties
     * 错误页指派：
     *      我们访问网站不存在的资源时，服务端找不到相应的资源时，浏览器常常报404（以及其他情况）
     *      此时会暴露给用户一部分代码及错误信息，对用户很不友好
     *      原理：根据请求头中的Accept属性值，判断返回的是页面还是json数据
     *      springboot提供了自定义错误页的功能：
     *          1）resource/public/error/404.html    在此路径下定义静态html页面，状态码与文件名一致
     *          2）resource/templates/error/404.html 在此路径下定义动态html页面
     *             （基于模板引擎freemarker或thymeleaf），状态码与文件名一致
     *          注：两者同时存在时后者优先级更高
     *              多对一，4xx.html可代表所有状态码以4开头的页面
     *              查找机制，举例：优先查找404，发现没有找4xx，还没有则返回springboot默认提供的空白页
     *          3）自定义一个类实现ErrorViewResolver接口，重写resolveErrorView方法
     *              将类交由spring管理，自定义处理响应结果，当1,2,3种方式同时存在时，3优先级更高
     *          4）使用WebServerFactoryCustomizer来注册bean，通过更改服务器出错时访问的路径来指定不同的页面
     *          注：优先级4 > 3 > 2 > 1
     * 全局异常的处理：
     *      通常状态码以4开头表示错误，5开头表示异常，同样需要对异常进行处理
     *      1）通过@ControllerAdvice监听所有在controller中出现的异常
     *          执行@ExceptionHandler下的方法，跳转错误页，进行友好提示
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(ErrorAndExceptionApplication.class, args);
    }

}
