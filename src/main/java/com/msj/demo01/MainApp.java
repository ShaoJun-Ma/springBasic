package com.msj.demo01;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//依赖注入---属性注入
public class MainApp {

    @Test
    public void testDemo(){
        //1、使用ApplicationContext容器
        ApplicationContext context = new ClassPathXmlApplicationContext("bean01.xml");
        //2、从容器中获取bean
        HelloWorld hello = context.getBean("hello",HelloWorld.class);
        System.out.println(hello);
        System.out.println(hello.getMessage());
    }
}
