package com.test.demo.redis.sub;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/***
 * 消息接收者（订阅者）  需要注入到springboot中
 */
@Slf4j
@Component
public class RedisReceiver {

    private CountDownLatch latch;

    @Autowired
    public RedisReceiver(CountDownLatch latch) {
        this.latch = latch;
    }


    /**
     *  收到通道的消息之后执行的方法
     * @param message
     */
    public void receiveMessage(String message) {
        //这里是收到通道的消息之后执行的方法
        log.info("我收到通道里你发的的消息了....." + message);

        latch.countDown();
    }
}