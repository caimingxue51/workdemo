package com.test.demo.design.decorator;

public class OldAge extends Age {
    @Override
    public String disguise() {
        return super.disguise() + "老年";
    }
}
