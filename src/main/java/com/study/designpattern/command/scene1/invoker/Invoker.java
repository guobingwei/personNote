package com.study.designpattern.command.scene1.invoker;

import com.study.designpattern.command.scene1.command.Command;

/**
 * Created with IntelliJ IDEA.
 * Created by weiguobing on 2018/4/2.   下午10:02
 * email : weiguobing@meituan.com
 */
public class Invoker {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void action() {
        command.execute();
    }
}
