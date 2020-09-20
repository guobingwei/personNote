package com.dm.yc.std.study.designpattern.mediator.colleague;

import com.dm.yc.std.study.designpattern.mediator.mediator.Mediator;

/**
 * Created by guobingwei on 18/5/23.
 */
public class ConcreteColleague1 extends Colleague {


    public ConcreteColleague1(Mediator mediator) {
        super(mediator);
    }

    // 自有方法
    public void selfMethod1() {
        // do
    }

    // 依赖方法
    public void depMethod1() {
        // do

        // 不能处理的方法交给中介者处理
        super.mediator.doSomething1();
    }
}
