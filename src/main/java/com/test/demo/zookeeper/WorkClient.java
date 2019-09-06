package com.test.demo.zookeeper;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.exception.ZkNodeExistsException;
import org.apache.zookeeper.CreateMode;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class WorkClient {


    private ZkClient zkClient;

    private IZkDataListener zkDataListener;

    private String MASTER = "/nai-master";

    private String clientName;

    private boolean isRunning;

    private ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor( 1 );

    public WorkClient(ZkClient zkClient, String clientName) {
        this.zkClient = zkClient;
        this.clientName = clientName;
        this.zkDataListener = new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {

            }

            @Override
            public void handleDataDeleted(String s) throws Exception {
                // 删除时 3秒后重新选举
                executorService.schedule( () -> takeMaster(), 3, TimeUnit.SECONDS );
            }
        };
    }

    private boolean takeMaster() {
        // 创建master节点
        try {
            // 重新选举
            System.out.println( clientName + "开始竞争master" );
            zkClient.create( MASTER, clientName, CreateMode.EPHEMERAL );
            System.out.println( clientName + "成功被选中master" );
            // 3秒后释放master
            executorService.schedule( () -> releaseMaster(), 3, TimeUnit.SECONDS );

        } catch (ZkNodeExistsException e) {
            // 若节点已存在 则已经被选举
            return false;
        }
        return true;
    }

    private void releaseMaster() {
        zkClient.delete( MASTER );
    }


    public void start() {
        if (isRunning) {
            throw new RuntimeException( "server has running" );
        }

        isRunning = true;
        System.out.println( clientName + " server start..." );
        takeMaster();
        zkClient.subscribeDataChanges( MASTER, zkDataListener );
    }

    public void stop() {

        if (!isRunning) {
            throw new RuntimeException( clientName + "server has stop.." );
        }

        System.out.println( clientName + "server stop.." );
        zkClient.unsubscribeDataChanges( MASTER, zkDataListener );
        executorService.shutdown();
    }

}
