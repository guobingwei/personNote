package com.study.designPattern.chain;

/**
 * Created by guobing on 2016/4/25.
 */
public class FileLogger extends AbstractLogger {
    public FileLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard File::Logger: " + message);
    }
}
