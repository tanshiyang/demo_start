package com.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AutoPrintLineAspect {

    @Pointcut("@annotation(com.example.aop.PrintSomethingAnnotation)")
    public void printSomethingPointcut()
    {
    }

    @Before("printSomethingPointcut() && @annotation(printSomethingAnnotation)")
    public void beforePrintSomething(JoinPoint joinPoint, PrintSomethingAnnotation printSomethingAnnotation) throws Exception {
        System.out.println("Before PrintSomething");
        System.out.println("PrintSomethingAnnotation value:" + printSomethingAnnotation.value());
        System.out.println("PrintSomethingAnnotation description:" + printSomethingAnnotation.description());
    }

    @After("printSomethingPointcut()")
    public void afterPrintSomething(){
        System.out.println("After PrintSomething");
    }

    @AfterReturning(value = "printSomethingPointcut() && @annotation(printSomethingAnnotation)", returning = "value")
    public void afterReturnPrintSomething(PrintSomethingAnnotation printSomethingAnnotation, Object value){

    }
}
