package com.dm.yc.std.study.designpattern.bridge;

/**
 * Created by guobing on 2016/4/29.
 */
public class RedCircle implements DrawAPI {

    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("red circle : radius : " + radius + " x : " + x + " y : " + y);
    }
}
