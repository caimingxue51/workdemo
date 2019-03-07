package com.test.demo.bank.pay.bank.icb;

import com.test.demo.bank.pay.bank.GoodsDao;
import com.test.demo.bank.pay.bank.Pay;
import com.test.demo.bank.pay.bank.Strategy;
import com.test.demo.bank.pay.utils.BeanUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Pay(channelId = 1)
public class ICBCBank extends BeanUtils implements Strategy {
    @Resource
    private GoodsDao goodsDao;

    public GoodsDao getGoodsDao() {
        return goodsDao;
    }

    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }
    @Override
    public BigDecimal calRecharge(Integer channelId, Long goodsId) {

        System.out.println("我是ICBC");
        BigDecimal bigDecimal = new BigDecimal(1);
        return bigDecimal;
    }
 
}
