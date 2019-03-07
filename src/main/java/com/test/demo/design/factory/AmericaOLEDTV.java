package com.test.demo.design.factory;

public class AmericaOLEDTV implements TV {
    @Override
    public void power() {
        System.out.print("America power!");
    }
 
    @Override
    public void materials() {
        System.out.print("OLED screen!");
    }
}
