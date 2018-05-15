package com.study.designpattern.facade;

/**
 * Created by guobingwei on 18/5/14.
 */
public class ModenPostOfficeFacade {
    private ILetterProcess letterProcess;


    private Police police = new Police();

    public void sendLetter(String context, String address) {
        letterProcess.writeContext("sss");
        letterProcess.fillEnvelope("beijing");
        police.checkLetter(letterProcess);
        letterProcess.letterIntoEnvelope();
        letterProcess.sendLetter();
    }
}
