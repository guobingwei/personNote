package com.dm.yc.std.study.designpattern.bridge;


/**
 * Created by guobing on 2016/4/29.
 */
public class Circle extends Shape {
    public Circle(int radius, int x, int y, DrawAPI drawAPI) {
        super(drawAPI);
        this.radius = radius;
        this.x = x;
        this.y = y;
    }

    int x;
    int y;
    int radius;

    @Override
    public void draw() {
        drawAPI.drawCircle(radius, x, y);
    }
}
