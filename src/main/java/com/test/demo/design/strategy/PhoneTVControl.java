package com.test.demo.design.strategy;

public class PhoneTVControl implements TVControlBehavior{
    @Override
    public void controlTV() {
        System.out.println("Can use phone to control TV");
    }
}
