package com.study.designPattern.chain.pattern;

import com.study.designPattern.chain.pattern.AbstractLogger;

/**
 * Created by guobing on 2016/4/25.
 */
public class ConsoleLogger extends AbstractLogger {
    public ConsoleLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Console::Logger: " + message);
    }
}
