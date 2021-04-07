package com.lock;

import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;

public class LightweightLockTest {
 
    @Test
    public void test(){
        Object o = new Object();
        //Step 1
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        //Step 2
        synchronized(o) {
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
        //Step 3
        new Thread(()-> {
            synchronized(o) {
                System.out.println(ClassLayout.parseInstance(o).toPrintable());
            }
        }).start();
        //Step 4
        new Thread(()-> {
            synchronized(o) {
                System.out.println(ClassLayout.parseInstance(o).toPrintable());
            }
        }).start();

    }
}