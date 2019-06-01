package com.msj.demo02;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//构造器注入
public class MainApp {
    @Test
    public void testDemo(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean02.xml");
        HelloWorld helloWorld = context.getBean("helloWorld",HelloWorld.class);
        helloWorld.test();
    }
}
