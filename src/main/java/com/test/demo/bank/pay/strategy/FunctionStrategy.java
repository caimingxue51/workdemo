package com.test.demo.bank.pay.strategy;

import java.util.function.Function;
import java.util.function.Predicate;

public interface FunctionStrategy<P, T, R> {

    /**
     * 暴露当前策略的钩子
     *
     * @return 判断钩子
     */
    Predicate<P> predicate();

    /**
     * 暴露当前策略的生产逻辑
     *
     * @return 消费逻辑
     */
    Function<T, R> function();
}
