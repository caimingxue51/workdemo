package com.test.demo.design.observer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DefaultConsumer implements MsgConsumer {
    
    @Override
    public void msgArrivedCallBack(String msg) {
        log.debug("I received a msg: " + msg);
    }
}
