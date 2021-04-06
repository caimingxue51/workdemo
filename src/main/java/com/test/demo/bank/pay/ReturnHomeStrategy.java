package com.test.demo.bank.pay;

import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * 简化处理
 * String 代表来自区域风险系数
 * Integer 打工人
 */
enum ReturnHomeStrategy implements ConsumerStrategy<String, Integer> {
    /**
     * 高风险
     */
    HIGH_RISK(from -> "HIGH_RISK".equals(from), i -> {
        throw new RuntimeException("滚!");
    }),
    /**
     * 中风险
     */
    MIDDLE_RISK(from -> "MIDDLE_RISK".equals(from), i -> {
        throw new RuntimeException("滚!");
    }),
    /**
     * 低风险
     */
    LOW_RISK(from -> "LOW_RISK".equals(from), i -> {
        //todo 如果可以,也请滚
        //todo 核算检测
        //todo 居家隔离
    });

    private final Predicate<String> predicate;

    private final Consumer<Integer> consumer;

    ReturnHomeStrategy(Predicate<String> predicate, Consumer<Integer> consumer) {
        this.predicate = predicate;
        this.consumer = consumer;
    }

    @Override
    public Predicate<String> predicate() {
        return this.predicate;
    }

    @Override
    public Consumer<Integer> consumer() {
        return this.consumer;
    }
}
