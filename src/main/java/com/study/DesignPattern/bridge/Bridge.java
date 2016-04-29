package com.study.designPattern.bridge;

/**
 * Created by guobing on 2016/4/29.
 */
public class Bridge {
    public static void main(String [] args) {
        Shape redCircle = new Circle(100, 10, 10, new RedCircle());
        Shape greenCircle = new Circle(100, 10, 10, new GreenCircle());

        redCircle.draw();
        greenCircle.draw();
    }
}
