package com.test.demo.cglib;

import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;

public class CglibTest {

    @Test
    public void testCglib() {
        DaoProxy daoProxy = new DaoProxy();
        
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Dao.class);
        enhancer.setCallback(daoProxy);
        
        Dao dao = (Dao)enhancer.create();
        dao.update();
        dao.select();
    }
    
}