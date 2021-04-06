package com.test.demo.bank.pay.strategy;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * 简化处理
 * String 代表来自区域风险系数
 * Integer 打工人
 * String 村里开具证明
 */
enum ReturnHomeStrategy implements FunctionStrategy<String, Integer, String> {
    /**
     * 高风险
     */
    HIGH_RISK(from -> "HIGH_RISK".equals(from), i -> "滚!"),
    /**
     * 中风险
     */
    MIDDLE_RISK(from -> "MIDDLE_RISK".equals(from), i -> "滚!"),
    /**
     * 低风险
     */
    LOW_RISK(from -> "LOW_RISK".equals(from), i -> "村里的祸害回来了,给他做个核算检测!");

    private final Predicate<String> predicate;

    private final Function<Integer, String> function;

    public Predicate<String> getPredicate() {
        return predicate;
    }

    public Function<Integer, String> getFunction() {
        return function;
    }

    ReturnHomeStrategy(Predicate<String> predicate, Function<Integer, String> function) {
        this.predicate = predicate;
        this.function = function;
    }

    @Override
    public Predicate<String> predicate() {
        return this.predicate;
    }

    @Override
    public Function<Integer, String> function() {
        return this.function;
    }
}
