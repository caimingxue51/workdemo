package com.test.demo.design.command;

import java.util.HashMap;
import java.util.Map;

/**
 * 好处：
 * 1.请求方和具体的执行方实现解耦，请求方不需要知道具体如何执行，只需下命令给执行方就行。
 */
public class RemoteControl {
    private Map<String, Command> commandMap;
 
    public RemoteControl() {
        commandMap = new HashMap<>();
    }
 
    public void setCommand(String cmdType, Command cmd) {
        commandMap.put(cmdType, cmd);
    }
 
    public void pressButton(String cmdType) {
        commandMap.get(cmdType).execute();
    }
}
