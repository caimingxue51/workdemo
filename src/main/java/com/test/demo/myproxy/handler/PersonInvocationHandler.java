package com.test.demo.myproxy.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author:cai.chaoxiong
 * @Date: 2019/3/7 11:02
 */
public class PersonInvocationHandler implements InvocationHandler {
    private Object obj;

    public PersonInvocationHandler(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before time to eat");
        method.invoke(obj, args);
        System.out.println("after time to eat");
        return null;
    }
}
