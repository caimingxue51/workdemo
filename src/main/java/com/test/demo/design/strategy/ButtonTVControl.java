package com.test.demo.design.strategy;

public class ButtonTVControl implements TVControlBehavior{
    @Override
    public void controlTV() {
        System.out.println("Can use button to control TV");
    }
}
