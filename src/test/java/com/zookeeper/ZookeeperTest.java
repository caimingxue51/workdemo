package com.zookeeper;

import com.test.demo.zookeeper.DistributReetrantLock;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryOneTime;
import org.apache.curator.utils.CloseableUtils;

/**
 *
 * @Author:cai.chaoxiong
 * @Date: 2020/12/14 15:30
 */
public class ZookeeperTest {

    public static void main(String[] args) throws InterruptedException {
        //分布式可重入排它锁
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        final String lockPath = "/lock";

        for (int i = 0; i < 5; i++) {
            final int clientIndex = i;
            Callable<Void> callable = new Callable<Void>() {

                public Void call() throws Exception {
                    CuratorFramework simpleClient = createSimpleClient("127.0.0.1:2181");

                    try {
                        simpleClient.start();

                        DistributReetrantLock distributReetrantLock = new DistributReetrantLock(simpleClient, lockPath);
                        // 阻塞式获取
                        distributReetrantLock.tryLock();
                        System.out.println("Client:" + clientIndex + " get lock!");
                        // 验证是否是可重入的
                        distributReetrantLock.tryLock();
                        System.out.println("Client:" + clientIndex + " get lock again!");

                        Thread.sleep(1000);
                        // 持有锁一秒后释放，以便其他客户端获取到锁
                        System.out.println("Client:" + clientIndex + " release lock!");
                        distributReetrantLock.unLock();
                    }catch (Exception e){
                     e.printStackTrace();
                    }

                    finally {
                        CloseableUtils.closeQuietly(simpleClient);
                    }

                    return null;
                }
            };
            executorService.submit(callable);
        }

        executorService.awaitTermination(10, TimeUnit.MINUTES);

    }

    private static CuratorFramework createSimpleClient(String connectionString) {
        return CuratorFrameworkFactory.builder()
                .connectString(connectionString)
                .retryPolicy(new RetryOneTime(2000))
                .connectionTimeoutMs(6000)
                .sessionTimeoutMs(180000)
                .build();
    }

    public static CuratorFramework createWithOptions(String connectionString, RetryPolicy retryPolicy, int connectionTimeoutMs, int sessionTimeoutMs){
        return CuratorFrameworkFactory.builder()
                .connectString(connectionString)
                .retryPolicy(retryPolicy)
                .connectionTimeoutMs(connectionTimeoutMs)
                .sessionTimeoutMs(sessionTimeoutMs)
                .build();
    }
}
