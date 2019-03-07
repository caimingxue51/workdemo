package com.test.demo.design.observer;

public interface MsgObservable {
 
    void removeConsumer(MsgConsumer consumer);
 
    void registerConsumer(MsgConsumer consumer);
 
    void notifyMsgReceived(String msg);
 
    void receivedMsg(String msg);
}
