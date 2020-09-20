package com.dm.yc.std.study.designpattern.command.scene1.command;

/**
 * Created with IntelliJ IDEA.
 * Created by weiguobing on 2018/4/2.   下午10:01
 * email : weiguobing@meituan.com
 */
public class AddRequirementCommand extends Command {
    @Override
    public void execute() {
        super.rg.find();
        super.pageGroup.add();
        super.codeGroup.plan();

        super.pageGroup.find();
        super.pageGroup.add();
        super.pageGroup.plan();

        super.codeGroup.find();
        super.codeGroup.add();
        super.codeGroup.plan();
    }
}
