package com.msj.demo07;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component
@Component(value = "ddd")
public class DDD implements Service{

    public void say() {
        System.out.println("Ddd");
    }
}
