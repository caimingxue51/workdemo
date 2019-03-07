package com.test.demo.design.command;

public class AirConditionerRegulateCmd implements Command{
 
    private AirConditioner airConditioner;
 
    public AirConditionerRegulateCmd(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }
    @Override
    public void execute() {
        airConditioner.regulate();
    }
}
