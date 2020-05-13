package com.test.demo.bank.pay;

import com.test.demo.bank.pay.bank.Context;

/**
 * @author: LKP
 * @date: 2019/1/2
 */
public class TestMain {
 
    public static void test() throws Exception {
        Context context = new Context();
        System.out.println(context.chalRecharge(2,2L));
    }
 
}
