package com.test.demo.bank.pay.bank;

import java.math.BigDecimal;

/**
 * @Author:cai.chaoxiong
 * @Date: 2019/1/3 10:23
 */
public interface Strategy {
    /**
     * 根据支付渠道类型去调用银行的优惠信息
     * @param channelId
     * @return
     */
    public BigDecimal calRecharge(Integer channelId,Long goodsId);
}
