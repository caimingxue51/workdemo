package com.test.demo.design.strategy;

public class RemoteTVControl implements TVControlBehavior{
    @Override
    public void controlTV() {
        System.out.println("Can use 'TV remote control device' to control TV");
    }
}
