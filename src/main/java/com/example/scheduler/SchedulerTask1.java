package com.example.scheduler;

import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@EnableScheduling
public class SchedulerTask1 {

    private int count = 0;

    /**
     * @return void
     * @Author Smith
     * @Description 设置没6秒执行一次
     * @Date 14:23 2019/1/24
     * @Param
     **/
    @Async
    @Scheduled(fixedRate = 3000)
    private void process() {
        System.out.println("this is scheduler task running " + (count++));
    }

    /**
     * @return void
     * @Author Smith
     * @Description 设置没6秒执行一次
     * @Date 14:22 2019/1/24
     * @Param
     **/
    @Async
    @Scheduled(fixedRate = 6000)
    private void process2() throws InterruptedException {
        SimpleDateFormat dateFormat =
                new SimpleDateFormat("HH:mm:ss");
        System.out.println("now time is " + dateFormat.format(new Date()));
        Thread.sleep(1000 * 10L);
    }

}