package com.test.demo.lock.jdk;

import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.openjdk.jol.info.ClassLayout;

/**
 * 内置锁测试
 *
 * @author Mr.CCX
 * @date 2021-04-06 09:54
 **/
@Slf4j
public class LockSycn {

    /*public static void main(String[] args) throws IOException, InterruptedException {
        Integer i = Integer.valueOf(5);
        log.debug(ClassLayout.parseInstance(i).toPrintable());
    }*/

    public static void main(String[] args) throws IOException, InterruptedException {
        test1();
    }
    // 测试偏向锁
    private static void test1() {
        Dog d = new Dog();
        //偏向锁延迟，所以创建完对象之后还是无锁状态
        log.debug(ClassLayout.parseInstance(d).toPrintable());
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //延迟4s之后，输出偏向锁状态
        log.debug(ClassLayout.parseInstance(new Dog()).toPrintable());
    }

    static class Dog {
    }
}
