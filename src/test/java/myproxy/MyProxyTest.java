package myproxy;

import com.test.demo.myproxy.Person;
import com.test.demo.myproxy.PersonImpl;
import com.test.demo.myproxy.proxy.MyClassLoader;
import com.test.demo.myproxy.handler.MyPersonInvocationHandler;
import com.test.demo.myproxy.handler.PersonInvocationHandler;
import com.test.demo.myproxy.proxy.MyProxy;
import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * @Author:cai.chaoxiong
 * @Date: 2019/3/7 11:04
 */
public class MyProxyTest {
    @Test
    public void proxyEat(){
        PersonInvocationHandler personInvocationHandler = new PersonInvocationHandler(
                new PersonImpl());
        Person personProxy = (Person) Proxy.newProxyInstance(
                PersonImpl.class.getClassLoader(),
                PersonImpl.class.getInterfaces(), personInvocationHandler);
        personProxy.eat();
    }
    @Test
    /**
     * 本测试与lombok包有冲突，会产生一个 警告
     */
    public void myProxyEat(){
        MyPersonInvocationHandler personInvocationHandler = new MyPersonInvocationHandler(
                new PersonImpl());
        Person personProxy = (Person) MyProxy.newProxyInstance(
                new MyClassLoader(),
                PersonImpl.class.getInterfaces(), personInvocationHandler);
        personProxy.eat();
    }
}
