package com.xingyu.config;

import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.boot.web.reactive.context.ReactiveWebServerInitializedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerConfig {

    @EventListener(WebServerInitializedEvent.class)
    public void onWebServerReady(WebServerInitializedEvent event){
        System.out.println("ListenerConfig: 当前WebServer实现类为：" + event.getWebServer().getClass().getName());
    }

}
