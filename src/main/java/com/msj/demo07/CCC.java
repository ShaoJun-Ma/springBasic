package com.msj.demo07;

import org.springframework.stereotype.Component;

@Component("ccc")
public class CCC implements Service{
    public void say() {
        System.out.println("我是CCC");
    }
}
