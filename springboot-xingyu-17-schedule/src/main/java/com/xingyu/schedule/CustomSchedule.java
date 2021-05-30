package com.xingyu.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CustomSchedule {
    //    @Scheduled(fixedDelay = 5000) //每次执行完成后的固定等待时间
//    @Scheduled(fixedRate = 5000) //每次执行启动后的固定间隔时间
    @Scheduled(cron = "0/5 * * * * ? ")
    public void execute(){
        System.out.println("任务执行！");
    }
}
