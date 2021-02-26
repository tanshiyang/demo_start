package com.example.aop;

import org.springframework.stereotype.Component;

@Component
public class UseSimpleAop {
    @AdminOnly
    public void justPrint() {
        System.out.println("test");
    }
}
