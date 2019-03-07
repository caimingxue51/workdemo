package com.test.demo.receiver.handler;

import com.test.demo.receiver.AbstractMessageHandler;
import com.test.demo.receiver.Handler;
import org.springframework.stereotype.Component;

/**
 * @Author:cai.chaoxiong
 * @Date: 2018/12/2 19:27
 */
@Component
@Handler("2")
public class LogHandler implements AbstractMessageHandler {
    @Override
    public void doProcess(String text) {

        System.out.println("我是LogHandler-我能处理："+text);
    }
}
