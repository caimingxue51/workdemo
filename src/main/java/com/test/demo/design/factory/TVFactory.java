package com.test.demo.design.factory;

public interface TVFactory {
    /**
     * 制造电视
     * @param type 用于指定生产哪种类型的电视比例OLED、LED等
     */
    TV manufactureTV(String type);
}
