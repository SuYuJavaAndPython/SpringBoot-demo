package com.xingyu.listener;

import com.xingyu.event.CustomEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CustomListener3 {

    @EventListener
    public void onApplicationEvent(CustomEvent customEvent) {
        customEvent.printMessage("Listener3监听到了");
    }
}
