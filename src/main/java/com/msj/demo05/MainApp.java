package com.msj.demo05;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//aop---使用注解
public class MainApp {
    @Test
    public void testDemo(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean05.xml");
        AAA aa = context.getBean("aa",AAA.class);
        aa.say();
    }
}
