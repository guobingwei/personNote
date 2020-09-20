package com.dm.yc.std.study.designpattern.command.scene1.command;


/**
 * Created with IntelliJ IDEA.
 * Created by weiguobing on 2018/4/2.   下午9:59
 * email : weiguobing@meituan.com
 */
public class DeletePageCommand extends Command {

    @Override
    public void execute() {
        super.pageGroup.find();
        super.pageGroup.add();
        super.pageGroup.plan();
    }
}
