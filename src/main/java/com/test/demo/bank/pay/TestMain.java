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

    public static void main(String[] args) {
       new TestMain().returnHome("HIGH_RISK",1);
    }



    /**
     * 某人回家
     *
     * @param from 代表来自区域风险系数
     * @param id   打工人
     */
    public void returnHome(String from, Integer id) {
        for (ReturnHomeStrategy value : ReturnHomeStrategy.values()) {
            value.handle(from, id);
        }
    }

}
