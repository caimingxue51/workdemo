package com.test.demo.myproxy.handler;

/**
 * @Author:cai.chaoxiong
 * @Date: 2019/3/7 11:08
 */
import java.lang.reflect.Method;

public interface MyInvocationHandler {

    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;

}