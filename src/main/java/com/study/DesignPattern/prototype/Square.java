package com.study.DesignPattern.prototype;

/**
 * Created by guobing on 2016/4/13.
 */
public class Square extends Shape {
    public Square() {
        this.type = "Square";
    }

    @Override
    void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
