package com.test.demo.design.decorator;

public class MaleHuman implements Human {
 
    private Human human;
 
    public MaleHuman(Human human) {
        this.human = human;
    }
    public String disguise() {
        return human.disguise() + "男人";
    }
}
