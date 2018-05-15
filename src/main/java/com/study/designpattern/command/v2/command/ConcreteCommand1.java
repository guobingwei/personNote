package com.study.designpattern.command.v2.command;

import com.study.designpattern.command.v2.receiver.Receiver;

/**
 * Created with IntelliJ IDEA.
 * Created by weiguobing on 2018/4/2.   下午9:28
 * email : weiguobing@meituan.com
 */
public class ConcreteCommand1 extends Command {
    private Receiver receiver;

    public ConcreteCommand1(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        this.receiver.doSomething();
    }
}
