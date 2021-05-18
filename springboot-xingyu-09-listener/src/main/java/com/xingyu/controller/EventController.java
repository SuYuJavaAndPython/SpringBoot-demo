package com.xingyu.controller;

import com.xingyu.event.CustomEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

    @Autowired
    private ApplicationEventPublisher publisher;

    /**
     * 这个event方法就是具体的事件源，当event方法被执行时即代表某些事件需要被响应
     * 然后由ApplicationEventPublisher的对象对某些事件进行发布
     * 然后由事件广播器ApplicationEventMulticaster的对象会去事件注册表ApplicationContext中找到事件监听器
     * ApplicationListener，并且逐个执行监听器的onApplicationEvent方法，从而完成事件监听器的逻辑
     * @return
     */
    @RequestMapping("/event")
    public String event(){
        publisher.publishEvent(new CustomEvent(this));
        return "success";
    }
}
