package com.test.demo.design.adapter;

import java.util.Map;
 
public class TVRemoteControl implements TVControl {
 
    private Map<Integer, Object> showMap;
    private int nowShowNumber = 0;
    private int totalShowNumber;
 
    public TVRemoteControl(Map<Integer, Object> showMap) {
        this.showMap = showMap;
        totalShowNumber = showMap.size();
    }
 
    @Override
    public void startTV() {
        System.out.print("TV has been started.");
    }
 
    @Override
    public void stopTV() {
        System.out.print("TV has been stop.");
    }
 
    @Override
    public void nextShow() {
        nowShowNumber++;
        if (nowShowNumber >= totalShowNumber) {
            nowShowNumber = 0;
        }
        System.out.print("see the next show, the show number is " + nowShowNumber);
        System.out.print("the show is " + showMap.get(nowShowNumber).toString());
    }
 
    @Override
    public void prevShow() {
        nowShowNumber--;
        if (nowShowNumber < 0) {
            nowShowNumber = totalShowNumber - 1;
        }
        System.out.print("see the previous show, the show number is " + nowShowNumber);
        System.out.print("the show is " + showMap.get(nowShowNumber).toString());
    }
}
