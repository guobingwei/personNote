package com.dm.yc.std.study.designpattern.facade;

/**
 * Created by guobingwei on 18/5/14.
 */
public class Police {
    public void checkLetter(ILetterProcess letterProcess) {
        System.out.println("检测信件:" + letterProcess);
    }
}
