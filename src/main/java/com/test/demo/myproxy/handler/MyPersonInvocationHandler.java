package com.test.demo.myproxy.handler;

import java.lang.reflect.Method;

/**
 * @Author:cai.chaoxiong
 * @Date: 2019/3/7 11:13
 */
public class MyPersonInvocationHandler implements MyInvocationHandler {

    private Object obj;

    public MyPersonInvocationHandler(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        // TODO Auto-generated method stub
        System.out.println("before time to eat");
        method.invoke(obj, args);
        System.out.println("after time to eat");
        return null;
    }
}
