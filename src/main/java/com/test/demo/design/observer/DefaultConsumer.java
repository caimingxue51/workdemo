package com.test.demo.design.observer;

public class DefaultConsumer implements MsgConsumer {
    
    @Override
    public void msgArrivedCallBack(String msg) {
        System.out.println("I received a msg: " + msg);
    }
}
