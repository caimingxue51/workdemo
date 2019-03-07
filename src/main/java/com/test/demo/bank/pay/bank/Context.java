package com.test.demo.bank.pay.bank;

import org.reflections.Reflections;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: LKP
 * @date: 2019/1/2
 */
@Component
public class Context {
    public static ConcurrentHashMap<Integer, Strategy> source_map = new ConcurrentHashMap<Integer, Strategy>();

    /**
     * 根据上文（渠道ID）得到下文（具体的某个实现类）
     *
     * @param channlId
     * @return
     */
    public BigDecimal chalRecharge(Integer channlId, Long goodsId) throws Exception {

        // 我们需要一个类帮我们创建具体的实现类，怎么创建的，我不关心，我的
        // 条件就是channlid
        Strategy strategy = null;
        if (source_map.containsKey( channlId )) {
            strategy = source_map.get( channlId );
        } else {
            StrategyFactory strategyFactory = StrategyFactory.getInstance();
            strategy = strategyFactory.create( channlId );
            source_map.put( channlId, strategy);
        }
        return strategy.calRecharge( channlId, goodsId );
    }
}
