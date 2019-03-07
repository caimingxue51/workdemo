package com.test.demo.receiver;

import org.springframework.amqp.core.Message; /**
 * @Author:cai.chaoxiong
 * @Date: 2018/12/2 19:12
 */
public interface AbstractMessageHandler {
    void doProcess(String text);
}
