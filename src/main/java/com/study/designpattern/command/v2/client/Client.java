package com.study.designpattern.command.v2.client;

import com.study.designpattern.command.v2.command.Command;
import com.study.designpattern.command.v2.command.ConcreteCommand1;
import com.study.designpattern.command.v2.invoker.Invoker;
import com.study.designpattern.command.v2.receiver.ConcreteReceiver1;
import com.study.designpattern.command.v2.receiver.Receiver;

/**
 * Created with IntelliJ IDEA.
 * Created by weiguobing on 2018/4/2.   下午9:32
 * email : weiguobing@meituan.com
 */
public class Client {
    public static void main(String[] args) {
        Invoker invoker = new Invoker();
        Receiver receiver = new ConcreteReceiver1();
        Command command = new ConcreteCommand1(receiver);
        invoker.setCommand(command);
        invoker.action();
    }
}
