package com.test.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class DemoApplicationTests {

	@Test
	public String contextLoads() {
	    String PON_PORT= "/R1/S1/1/1";
	    if(PON_PORT !=null && PON_PORT.length()>1){
            return  PON_PORT.substring( 1 ).replace( "/","-" ).replaceAll( "[(A-Za-z)]","" );
        }else {
            return  PON_PORT;
        }
        //System.out.println( PON_PORT.substring( 1 ).replace( "/","-" ).replaceAll( "[(A-Za-z)]","" ) );
	}
    /*public volatile int inc = 0;

    public void increase() {
        inc++;
    }

    @Test
    public  void test1() {
        final DemoApplicationTests test = new DemoApplicationTests();
        for(int i=0;i<10;i++){
            new Thread(){
                public void run() {
                    for(int j=0;j<10000;j++)
                        test.increase();
                };
            }.start();
        }

        while(Thread.activeCount()>1)  //保证前面的线程都执行完
            Thread.yield();
        System.out.println(test.inc);
        System.out.println(1);
    }*/
    /*public  int inc = 0;

    public synchronized void increase() {
        inc++;
    }

    @Test
    public  void test2() {
        final DemoApplicationTests test = new DemoApplicationTests();
        for(int i=0;i<10;i++){
            new Thread(){
                public void run() {
                    for(int j=0;j<1000;j++)
                        test.increase();
                };
            }.start();
        }

        while(Thread.activeCount()>1)  //保证前面的线程都执行完
            Thread.yield();
        System.out.println(test.inc);
    }*/

    /*public  int inc = 0;
    Lock lock = new ReentrantLock();

    public  void increase() {
        lock.lock();
        try {
            inc++;
        } finally{
            lock.unlock();
        }
    }

    @Test
    public  void test2() {
        final DemoApplicationTests test = new DemoApplicationTests();
        for(int i=0;i<10;i++){
            new Thread(){
                public void run() {
                    for(int j=0;j<1000;j++)
                        test.increase();
                };
            }.start();
        }

        while(Thread.activeCount()>1)  //保证前面的线程都执行完
            Thread.yield();
        System.out.println(test.inc);
    }*/

    public AtomicInteger inc = new AtomicInteger();

    public  void increase() {
        inc.getAndIncrement();
    }

    @Test
    public  void test2() {
        final DemoApplicationTests test = new DemoApplicationTests();
        for(int i=0;i<10;i++){
            new Thread(){
                public void run() {
                    for(int j=0;j<1000;j++)
                        test.increase();
                };
            }.start();
        }

        while(Thread.activeCount()>1)  //保证前面的线程都执行完
            Thread.yield();
        System.out.println(test.inc);
    }
}
