package com.msj.demo05;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
//声明是一个切面
public class Logging {
    //声明一个切点
    @Pointcut("execution(* com.msj.demo05.*.*(..))")
    public void say(){}

    @Before("say()")
    public void before(){
        System.out.println("之前");
    }

    @After("say()")
    public void after(){
        System.out.println("之后");
    }
}
