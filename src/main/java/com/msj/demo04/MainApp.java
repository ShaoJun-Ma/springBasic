package com.msj.demo04;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//aop:不使用注解
public class MainApp {
    @Test
    public void testDemo(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean04.xml");
        AAA aa = context.getBean("aa",AAA.class);
        aa.say();

    }
}
