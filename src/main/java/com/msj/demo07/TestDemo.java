package com.msj.demo07;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean07.xml")
public class TestDemo {

    @Autowired
    @Qualifier("ccc")
    private Service service;
    @Test
    public void test(){
        service.say();
    }
}
