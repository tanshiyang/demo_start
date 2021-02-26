package com.example.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AutoPrintLineAspect {

    @Pointcut("@annotation(AdminOnly)")
    public void adminOnly()
    {
        System.out.println("Admin Only");
    }

    @Before("adminOnly()")
    public void beforeAdminOnly(){
        System.out.println("Before Admin Only");
    }

    @After("adminOnly()")
    public void afterAdminOnly(){
        System.out.println("After Admin Only");
    }
}
