package com.study.designpattern.command.scene1.command;

import com.study.designpattern.command.scene1.receiver.CodeGroup;
import com.study.designpattern.command.scene1.receiver.PageGroup;
import com.study.designpattern.command.scene1.receiver.RequirementGroup;

/**
 * Created with IntelliJ IDEA.
 * Created by weiguobing on 2018/4/2.   下午9:58
 * email : weiguobing@meituan.com
 */
public abstract class Command {

    RequirementGroup rg = new RequirementGroup();
    CodeGroup codeGroup = new CodeGroup();
    PageGroup pageGroup = new PageGroup();

    public abstract void execute();

}
