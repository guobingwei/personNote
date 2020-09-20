package com.dm.yc.std.study.designpattern.prototype;

/**
 * Created by guobing on 2016/4/13.
 */
public class Circle extends Shape{

    public Circle() {
        type = "Circle";
    }

    @Override
    void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
