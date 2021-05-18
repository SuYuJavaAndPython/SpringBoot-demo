package com.xingyu.event;

import org.springframework.context.ApplicationEvent;

/**
 *  自定义事件状态对象
 */
public class CustomEvent extends ApplicationEvent {

    public CustomEvent(Object source) {
        //事件源
        super(source);
    }

    public void printMessage(String msg){
        System.out.println("事件打印信息："+msg);
    }
}
