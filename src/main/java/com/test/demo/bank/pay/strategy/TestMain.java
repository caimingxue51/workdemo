package com.test.demo.bank.pay.strategy;

import com.test.demo.bank.pay.bank.Context;

/**
 * @author: LKP
 * @date: 2019/1/2
 */
public class TestMain {


    public static void main(String[] args) {
        System.out.println(new TestMain().returnHome("LOW_RISK",1));
    }



    /**
     * 某人回家
     *
     * @param from 代表来自区域风险系数
     * @param id   打工人
     * @return 要证明
     */
    public String returnHome(String from, Integer id) {
        for (ReturnHomeStrategy value : ReturnHomeStrategy.values()) {
            if (value.predicate().test(from)) {
                return value.function().apply(id);
            }
        }
        throw new RuntimeException("外星人,抓起来放进动物园卖门票!");
    }


}
