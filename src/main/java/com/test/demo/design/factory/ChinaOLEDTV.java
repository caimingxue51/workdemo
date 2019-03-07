package com.test.demo.design.factory;

public class ChinaOLEDTV implements TV {
    @Override
    public void power() {
        System.out.print("China power!");
    }
 
    @Override
    public void materials() {
        System.out.print("OLED screen!");
    }
}
