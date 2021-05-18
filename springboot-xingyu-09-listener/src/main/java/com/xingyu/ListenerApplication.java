package com.xingyu;

import com.xingyu.listener.CustomListener1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ListenerApplication {

    public static void main(String[] args) {
        /**
         *  在Spring框架中实现事件监听的流程如下：
         *         1) 自定义事件，继承org.springframework.context.ApplicationEvent抽象类
         *         2) 定义事件监听器，实现org.springframework.context.ApplicationListener接口
         *         3) 在Spring容器中发布事件
         */

        /**
         * 提供了四种实现监听的方式：
         *   1) 自定义类实现ApplicationListener接口，并且在入口主函数中使用
         *      ConfigurableApplicationContext容器装载监听
         *   2) 自定义类实现ApplicationListener接口，在接口上注解@Component
         *   3) 自定义类不需要实现接口，在方法上标明@EventListener注解 （主要通过
         *          EventListenerMethodProcessor扫描出所有带有此注解的方法，
         *         然后动态构造事件监听器，并将监听器托管到Spring应用上文中）
         *   4）在application.properties中配置context.listener.classes
         *         （DelegatingApplicationListener，该类的作用是从application.properties中读取配置
         *         context.listener.classes，并将事件广播给这些配置的监听器）
         */

        ConfigurableApplicationContext context = SpringApplication.run(ListenerApplication.class, args);
        context.addApplicationListener(new CustomListener1());

        /**
         * 对一个事件状态对象注册四个监听器（四种方式）执行顺序如下：
         * 事件打印信息：Listener4监听到了
         * 事件打印信息：Listener2监听到了
         * 事件打印信息：Listener3监听到了
         * 事件打印信息：Listener1监听到了
         * 先扫描配置文件，然后注册bean，然后注册监听
         */
    }

}
