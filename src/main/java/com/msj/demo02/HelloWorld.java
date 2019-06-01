package com.msj.demo02;

public class HelloWorld {

    private Hello hello;

    public HelloWorld(Hello hello){
        this.hello = hello;
        System.out.println("这是HelloWorld构造器");
    }

    public void test(){
        hello.testHello();
    }
}
