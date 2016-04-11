package com.study.DesignPattern.Factory;

/**
 * 工厂模式测试类
 * Created by john on 2016/4/11.
 */
public class FactoryDemo {
    public static void  main(String [] args) {
        AnimalsFactory animalsFactory = new AnimalsFactory();

        Animal cat = animalsFactory.getAnimal("cat");
        cat.say();

        Animal bird = animalsFactory.getAnimal("bird");
        bird.say();
    }
}
