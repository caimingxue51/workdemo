package com.test.demo.design.adapter;

public class KeyboardTVControlAdapt implements KeyboardControl {
 
    private TVControl control;
 
    public KeyboardTVControlAdapt(TVControl control) {
        this.control = control;
    }
 
    @Override
    public void ctrlsButton() {
        control.startTV();
    }
 
    @Override
    public void ctrlxButton() {
        control.stopTV();
    }
 
    @Override
    public void ctrlnButton() {
        control.nextShow();
    }
 
    @Override
    public void ctrlpButton() {
        control.prevShow();
    }
}
