package com.msj.demo03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AAA {
    @Autowired
    private CCC c;
    public void say(){
        c.say();
    }
}
