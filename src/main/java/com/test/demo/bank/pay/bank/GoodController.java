package com.test.demo.bank.pay.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.RoundingMode;

/**
 * @Author:cai.chaoxiong
 * @Date: 2019/2/21 16:48
 */
@RestController
public class GoodController {
    @Autowired
    Context context;

    @RequestMapping("/test")
    public  String testpay(Integer id){
        try {

            return context.chalRecharge( id,2L ).setScale(2, RoundingMode.HALF_UP).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ERROR";
    }
}
