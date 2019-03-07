package com.test.demo.design.command;

public class AirConditionerOnCmd implements Command{
 
    private AirConditioner airConditioner;
 
    public AirConditionerOnCmd(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }
 
    @Override
    public void execute() {
        airConditioner.on();
    }
}
