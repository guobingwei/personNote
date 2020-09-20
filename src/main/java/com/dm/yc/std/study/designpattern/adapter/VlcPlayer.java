package com.dm.yc.std.study.designpattern.adapter;

/**
 * Created by guobing on 2016/4/29.
 */
public class VlcPlayer implements AdvancedMediaPlayer{

    @Override
    public void playVlc(String fileName) {
        System.out.println("fileName : " +fileName);
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("fileName : " +fileName);
    }
}
