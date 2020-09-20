package com.dm.yc.std.study.designpattern.bridge;

/**
 * Created by guobing on 2016/4/29.
 */
public abstract class Shape {
    public DrawAPI drawAPI;
    public Shape(DrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }
    public abstract void draw();
}
