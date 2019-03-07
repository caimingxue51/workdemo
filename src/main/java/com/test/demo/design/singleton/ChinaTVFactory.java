package com.test.demo.design.singleton;

import com.test.demo.design.factory.*;

public class ChinaTVFactory implements TVFactory {
    /**
     * volatile关键字声明保证多线程操作时变量的一致性问题，详情可以度娘
     */
    private volatile static ChinaTVFactory instance;
 
    /**
     * 私有化构造方法，避免其他地方对这个工厂类进行实例化
     */
    private ChinaTVFactory() {
 
    }
 
    public static ChinaTVFactory getInstance() {
        if (instance == null) {
            /**
             * 为啥要在这边加锁呢不在方法上面加呢，首先加锁是为了防止多线程操作导致多次实例化对象，
             * 在这边加是为了提高性能，只有在实例没有被实例化的情况下才会进入加锁逻辑。
             */
            synchronized (ChinaTVFactory.class) {
                if (instance == null) {
                    instance = new ChinaTVFactory();
                }
            }
        }
        return instance;
    }
    @Override
    public TV manufactureTV(String type) {
        TV tv = null;
        switch (type) {
            case "LED":
                tv = new ChinaLEDTV();
                break;
            case "OLED":
                tv = new ChinaOLEDTV();
                break;
        }
        return tv;
    }
}
