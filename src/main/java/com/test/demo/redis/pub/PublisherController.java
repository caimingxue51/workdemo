package com.test.demo.redis.pub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    /**
     * push 消息
     * @param params
     * @return
     */
    @PostMapping("pushMsg")
    public String pushMsg(String params){
        return publisherService.pushMsg(params);
    }
}
