package com.test.demo.design.decorator;

public class FemaleHuman implements Human {
 
    private Human human;
 
    public FemaleHuman(Human human) {
        this.human = human;
    }
    public String disguise() {
        return human.disguise() + "女人";
    }
}
