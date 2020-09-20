package com.dm.yc.std.study.designpattern.chain;

/**
 * Created by guobing on 2016/4/25.
 */
public class ErrorLogger extends AbstractLogger {
    public ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Console::Logger: " + message);
    }
}
