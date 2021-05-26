package com.xingyu.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * 自定义健康指示器
 */
@Component
public class CustomHealth implements HealthIndicator {
    @Override
    public Health health() {
        int errorCode = 1;
        if(errorCode != 0){
            //返回不健康的指标并携带指标信息
            return Health.outOfService().withDetail("errorCode", errorCode).build();
        }
        //返回健康的指标
        return Health.up().build();
    }
}
