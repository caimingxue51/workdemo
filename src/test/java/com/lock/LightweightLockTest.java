package com.lock;

import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;

public class LightweightLockTest {
 
    @Test
    public void test(){
        Object o = new Object();
 
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
 
        synchronized (o){
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
        
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
    }
}