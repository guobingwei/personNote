package com.study.designpattern.mediator.colleague;

import com.study.designpattern.mediator.mediator.Mediator;

/**
 * Created by guobingwei on 18/5/23.
 */
public class ConcreteColleague2 extends Colleague {

    public ConcreteColleague2(Mediator mediator) {
        super(mediator);
    }

    public void selfMethod2() {

    }

    public void depMethod2() {
        // do self


        // other
        super.mediator.doSomething2();
    }
}
