package com.example.bean;

import org.springframework.context.annotation.Bean;

public class AppConfig {
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public MyBean myBean(){
        return new MyBean();
    }
}
