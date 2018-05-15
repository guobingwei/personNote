package com.study.designpattern.facade.impl;

import com.study.designpattern.facade.ILetterProcess;

/**
 * Created by guobingwei on 18/5/14.
 */
public class LetterProcessImpl implements ILetterProcess {
    @Override
    public void writeContext(String context) {
        System.out.println("写信：" + context);
    }

    @Override
    public void fillEnvelope(String address) {
        System.out.println("写信封地址:" + address);
    }

    @Override
    public void letterIntoEnvelope() {
        System.out.println("装入信封");
    }

    @Override
    public void sendLetter() {
        System.out.println("寄信");
    }
}
