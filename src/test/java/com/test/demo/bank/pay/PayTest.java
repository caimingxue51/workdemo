package com.test.demo.bank.pay;

import com.test.demo.bank.pay.bank.Context;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author:cai.chaoxiong
 * @Date: 2019/2/21 14:13
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PayTest {

    @Autowired
    Context context;
    @Test
    public  void testpay(){
        try {
            System.out.println(context.chalRecharge( 2,2L ));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
