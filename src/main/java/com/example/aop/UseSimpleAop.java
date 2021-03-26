package com.example.aop;

import org.springframework.stereotype.Component;

@Component
public class UseSimpleAop {
    @PrintSomethingAnnotation(value =  "zhangshan")
    public String justPrint(String content) {
        content = "hello "+ content;
        System.out.println(content);
        return content;
    }
}
