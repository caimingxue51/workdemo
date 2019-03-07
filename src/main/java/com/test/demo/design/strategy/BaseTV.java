package com.test.demo.design.strategy;

public class BaseTV {
    //通过传入的控制行为随意的定制或者改变电视机的控制方式
    private TVControlBehavior controlBehavior;
 
    public BaseTV(TVControlBehavior controlBehavior) {
        this.controlBehavior = controlBehavior;
    }
 
    /**
     * 通过调用控制行为的接口进行电视控制
     */
    public void controlTV() {
        controlBehavior.controlTV();
    }
 
    public void playShow() {
        System.out.print("Start playing TV shows");
    }
 
    /**
     * 可动态的随意改变电视控制方式
     * @param controlBehavior
     */
    public void setControlBehavior(TVControlBehavior controlBehavior) {
        this.controlBehavior = controlBehavior;
    }
}
