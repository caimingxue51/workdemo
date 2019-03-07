package com.test.demo.aop;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
/**
 * Created by peng on 18/6/29.
 */
@RestController
public class OldBoyController {
    @OldBoy
    @RequestMapping("/oldboy")
    public void getLog(){
        System.out.println("oldboy is coming");
    }
}