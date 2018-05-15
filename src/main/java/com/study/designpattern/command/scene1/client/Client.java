package com.study.designpattern.command.scene1.client;

import com.study.designpattern.command.scene1.command.AddRequirementCommand;
import com.study.designpattern.command.scene1.command.Command;
import com.study.designpattern.command.scene1.invoker.Invoker;

/**
 * Created with IntelliJ IDEA.
 * Created by weiguobing on 2018/4/2.   下午10:03
 * email : weiguobing@meituan.com
 */
public class Client {

    public static void main(String[] args) {
        Invoker guobing = new Invoker();
        Command command = new AddRequirementCommand();
        guobing.setCommand(command);
        guobing.action();
    }
}
