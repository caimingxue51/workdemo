package com.test.demo.design.observer;

import java.util.Vector;
 
public class MsgQueue implements MsgObservable {
 
    private Vector<MsgConsumer> obs;
 
    public MsgQueue() {
        obs = new Vector<>();
    }
 
    @Override
    public synchronized void removeConsumer(MsgConsumer consumer) {
        obs.removeElement(consumer);
    }
 
    @Override
    public synchronized void registerConsumer(MsgConsumer consumer) {
        if (consumer == null)
            throw new NullPointerException();
        if (!obs.contains(consumer)) {
            obs.addElement(consumer);
        }
    }
 
    @Override
    public void notifyMsgReceived(String msg) {
        Object[] arrLocal;
        synchronized (this) {
            arrLocal = obs.toArray();
        }
        for (int i = arrLocal.length-1; i>=0; i--)
            ((MsgConsumer)arrLocal[i]).msgArrivedCallBack(msg);
    }
 
    /**
     * 队列接收到一条消息时，将消息通知给所有订阅这个队列的消费者
     * @param msg
     */
    @Override
    public void receivedMsg(String msg) {
        System.out.print("queue received a msg: " + msg);
        notifyMsgReceived(msg);
    }
}
