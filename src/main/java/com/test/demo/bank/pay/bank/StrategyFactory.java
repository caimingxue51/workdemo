package com.test.demo.bank.pay.bank;

import org.reflections.Reflections;

import java.util.HashMap;
import java.util.Set;

/**
 * @author: LKP
 * @date: 2019/1/2
 */
public class StrategyFactory {
 
    private static StrategyFactory strategyFactory = new StrategyFactory();
 
    private StrategyFactory() {
    }
 
    public static HashMap<Integer, String> source_map = new HashMap<>();
 
    static {
        Reflections reflections = new Reflections("com.test.demo.bank.pay.bank");
        Set<Class<?>> classSet = reflections.getTypesAnnotatedWith(Pay.class);
 
        for (Class<?> aClass : classSet) {
            Pay pay = aClass.getAnnotation(Pay.class);
            source_map.put(pay.channelId(), aClass.getCanonicalName());
        }
    }
 
    /**
     * 具体的创建某个银行实现类的方法
     *
     * @param channelId
     * @return
     */
    public Strategy create(int channelId) throws Exception {
        //卡在没有map，现在有map
        String className = source_map.get(channelId);
        Class<?> aClass = Class.forName(className);
        return (Strategy) aClass.newInstance();
    }
 
    public static StrategyFactory getInstance() {
        return strategyFactory;
    }
 
}
