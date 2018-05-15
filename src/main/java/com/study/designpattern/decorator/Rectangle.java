package com.study.designpattern.decorator;

/**
 * Created by guobing on 2016/4/26.
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Shape: Rectangle");
    }
}
