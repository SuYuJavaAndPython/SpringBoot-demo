package com.xingyu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

/**
 * 访问端点以外的资源不用验证
 *      1.@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
 *      2.@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
 */
@SpringBootApplication
public class ActuatorApplication {

    /**
     * Actuator可以帮助监控和管理Spring Boot应用，比如健康检查、审计、统计和HTTP追踪等。
     * 所有的这些特性可以通过JMX或者HTTP endpoints来获得。
     * Actuator同时还可以与外部应用监控系统整合，比如 Prometheus, Graphite, DataDog, Influx,
     * Wavefront, New Relic等。这些系统提供了非常好的仪表盘、图标、分析和告警等功能，
     * 使得你可以通过统一的接口轻松的监控和管理你的应用。Actuator使用Micrometer来整合上
     * 面提到的外部应用监控系统。这使得只要通过非常小的配置就可以集成任何应用监控系统。
     *
     * 应用启动后，可以通过http://localhost:8090/actuator来展示所有通过HTTP暴露的endpoints。
     * 只有health和info通过HTTP暴露了出来，打开http://localhost:8090/actuator/health，会显示{"status":"UP"}
     *
     * GET /beans 描述应用程序上下文里全部的 Bean，以及它们的关系
     * GET /conditions 就是 1.0 的 /autoconfig ，提供一份自动配置生效的条件情况
     * GET /configprops 描述配置属性(包含默认值)如何注入Bean
     * GET /env 获取全部环境属性（/{name} 根据名称获取特定的环境属性值）
     * GET /health 报告应用程序的健康指标，这些值由 HealthIndicator 的实现类提供
     * GET /heapdump dump 一份应用的 JVM 堆信息
     * GET /info 获取应用程序的定制信息，这些信息由info打头的属性提供
     * GET /loggers 显示和修改配置的loggers
     * GET /metrics 报告各种应用程序度量信息，比如内存用量和HTTP请求计数(支持/{name} )
     * GET /scheduledtasks 展示应用中的定时任务信息
     * GET /sessions 如果我们使用了 Spring Session 展示应用中的 HTTP sessions 信息
     * GET /mappings 描述全部的 URI路径，以及它们和控制器(包含Actuator端点)的映射关系
     * GET /threaddump 获取线程活动的快照
     * GET /caches 显示可获取的缓存
     *
     * 在application.properties中设置
     * 1）打开或关闭endpoint
     * management.endpoint.<id>.enabled=true/false
     * 2）设置通过哪种方式暴露endpoints
     * management.endpoints.web.exposure.include=health,info #HTTP * 星号代表所有
     * 3）info信息只需要配置文件中的属性值以“info.”开头
     * info.app.name=spring-boot-actuator
     * info.app.version= 1.0.0
     * 4）有一个特殊的post操作命令/shutdown，可以关闭应用程序
     * 但前提是endpoints.shutdown.enabled需要设置为true
     *
     * security:
     *      1.当Spring项目中引入了Spring Security依赖的时候，项目会默认开启如下配置
     *      security.basic.enabled=true
     *      这个配置开启了一个表单认证，所有服务的访问都必须先过这个认证，
     *      默认的用户名为user，密码由Spring Security自动生成，回到IDE的控制台，可以找到密码信息
     *
     * 补充：1.汇总结果status的值依据所有健康指标（全为up则为up，有一个为down就为down
     *          有out_of_service无down则为out_of_service）
     *      2.health中ping指网络环境
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(ActuatorApplication.class, args);
    }

}
