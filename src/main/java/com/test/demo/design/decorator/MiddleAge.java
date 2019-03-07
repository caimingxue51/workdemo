package com.test.demo.design.decorator;

public class MiddleAge extends Age {
    public String disguise() {
        return super.disguise() + "中年";
    }
}
