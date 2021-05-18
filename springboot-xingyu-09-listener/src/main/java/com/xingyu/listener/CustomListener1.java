package com.xingyu.listener;

import com.xingyu.event.CustomEvent;
import org.springframework.context.ApplicationListener;

/**
 * 自定义事件监听者
 */
public class CustomListener1 implements ApplicationListener<CustomEvent> {
    @Override
    public void onApplicationEvent(CustomEvent customEvent) {
        customEvent.printMessage("Listener1监听到了");
    }
}
