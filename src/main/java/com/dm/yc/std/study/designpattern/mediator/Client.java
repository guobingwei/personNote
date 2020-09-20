package com.dm.yc.std.study.designpattern.mediator;

import com.dm.yc.std.study.designpattern.mediator.colleague.ConcreteColleague1;
import com.dm.yc.std.study.designpattern.mediator.colleague.ConcreteColleague2;
import com.dm.yc.std.study.designpattern.mediator.mediator.ConcreteMediator;
import com.dm.yc.std.study.designpattern.mediator.mediator.Mediator;

/**
 * Created by guobingwei on 18/5/23.
 */
public class Client {

    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();

        ConcreteColleague1 concreteColleague1 = new ConcreteColleague1(mediator);
        concreteColleague1.depMethod1();
        concreteColleague1.selfMethod1();

        ConcreteColleague2 colleague2 = new ConcreteColleague2(mediator);
        colleague2.depMethod2();
        colleague2.selfMethod2();
    }
}
