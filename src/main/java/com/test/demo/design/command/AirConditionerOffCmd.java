package com.test.demo.design.command;

public class AirConditionerOffCmd implements Command{
 
    private AirConditioner airConditioner;
 
    public AirConditionerOffCmd(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }
    @Override
    public void execute() {
        airConditioner.off();
    }
}
