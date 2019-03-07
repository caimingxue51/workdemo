package com.test.demo.design.factory;

public class AmericaTVFactory implements TVFactory {
    @Override
    public TV manufactureTV(String type) {
        TV tv = null;
        switch (type) {
            case "LED":
                tv = new AmericaLEDTV();
                break;
            case "OLED":
                tv = new AmericaOLEDTV();
                break;
        }
        return tv;
    }
}
