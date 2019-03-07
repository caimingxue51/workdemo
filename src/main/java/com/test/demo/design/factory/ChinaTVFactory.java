package com.test.demo.design.factory;

public class ChinaTVFactory implements TVFactory {
    @Override
    public TV manufactureTV(String type) {
        TV tv = null;
        switch (type) {
            case "LED":
                tv = new ChinaLEDTV();
                break;
            case "OLED":
                tv = new ChinaOLEDTV();
                break;
        }
        return tv;
    }
}
