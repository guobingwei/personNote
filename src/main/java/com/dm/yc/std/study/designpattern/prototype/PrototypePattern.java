package com.dm.yc.std.study.designpattern.prototype;

/**
 * Created by guobing on 2016/4/13.
 */
public class PrototypePattern {
    public static void main(String [] args) {
        ShapeCache.loadCache();

        Shape clonedShape = (Shape) ShapeCache.getShape("1");
        System.out.println("Shape : " + clonedShape.getType());

        Shape clonedShape2 = (Shape) ShapeCache.getShape("2");
        System.out.println("Shape : " + clonedShape2.getType());
    }
}
