package com.test.demo.zookeeper;

import java.util.concurrent.TimeUnit;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;

/**
 * @author miaomiao
 * @date 2020/10/25 11:15
 */
public class DistributReetrantLock {

    private final InterProcessMutex interProcessMutex;
    private final String lockPath;

    public DistributReetrantLock(CuratorFramework client, String lockPath) {
        this.lockPath = lockPath;
        // 此InterProcessMutex构造方法的maxLeases为1，表示为排他锁
        this.interProcessMutex = new InterProcessMutex(client, lockPath);
    }

    /**
     * 阻塞式获取
     */
    public void tryLock() throws Exception {
        this.interProcessMutex.acquire();
    }

    /**
     * 超时未获取到锁则获取锁失败
     * @param time
     * @param unit
     * @return 是否获取到锁
     * @throws Exception
     */
    public boolean tryLock(long time, TimeUnit unit) throws Exception {
        return this.interProcessMutex.acquire(time,unit);
    }

    /**
     * 释放锁
     * @throws Exception
     */
    public void unLock() throws Exception {
        this.interProcessMutex.release();
    }
}