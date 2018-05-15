package com.study.designpattern.facade;

/**
 * Created by guobingwei on 18/5/14.
 */
public interface ILetterProcess {
    void writeContext(String context);
    void fillEnvelope(String address);
    void letterIntoEnvelope();
    void sendLetter();
}
