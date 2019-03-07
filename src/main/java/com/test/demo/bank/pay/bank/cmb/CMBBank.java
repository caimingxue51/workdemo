package com.test.demo.bank.pay.bank.cmb;

import com.test.demo.bank.pay.bank.GoodsDao;
import com.test.demo.bank.pay.bank.Pay;
import com.test.demo.bank.pay.bank.Strategy;
import com.test.demo.bank.pay.utils.BeanUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author: LKP
 * @date: 2019/1/2
 */
@Pay(channelId = 2)
public class CMBBank extends BeanUtils implements Strategy {

    @Resource
    private GoodsDao goodsDao;

    public GoodsDao getGoodsDao() {
        return goodsDao;
    }

    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }

    @Override
    public BigDecimal calRecharge(Integer channelId,Long goodsId) {
        System.out.println("我是CMB"+goodsDao.hashCode());
        BigDecimal bigDecimal = new BigDecimal(0.98);
        return bigDecimal;
    }
 
}
