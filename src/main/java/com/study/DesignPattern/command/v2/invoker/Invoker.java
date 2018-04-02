package com.study.DesignPattern.command.v2.invoker;

import com.study.DesignPattern.command.v2.command.Command;

/**
 * Created with IntelliJ IDEA.
 * Created by weiguobing on 2018/4/2.   下午9:31
 * email : weiguobing@meituan.com
 */
public class Invoker {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void action() {
        this.command.execute();
    }
}
