package com.test.demo.spring;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import org.slf4j.LoggerFactory;

import java.util.List;
 
/**
 * @Author: ynz
 * @Date: 2018/12/22/022 8:48
 */
public class LogUtil {

    public static void setAllLogLevel(String level){
        LoggerContext loggerContext= (LoggerContext) LoggerFactory.getILoggerFactory();
        List<Logger> loggerList = loggerContext.getLoggerList();
        for(Logger logger : loggerList){
            logger.setLevel(Level.toLevel(level));
        }
    }

    public static void setLogLevel(String packages, String level) {
    }

}
