package com.msj.demo03;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//手动new和容器new的区别

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean03.xml")
public class testDemo {
    @Autowired
    private AAA a;
//    AAA a = new AAA();
    @Test
    public void test03(){
        a.say();
    }
}
