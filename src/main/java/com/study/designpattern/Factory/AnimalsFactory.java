package com.study.designpattern.Factory;

/**
 * Created by john on 2016/4/11.
 */
public class AnimalsFactory {
    public Animal getAnimal(String type) {
        if(type == null) {
            return null;
        }

        if(type == "cat") {
            return new Cat();
        } else if("bird".equals(type)) {
            return new Bird();
        } else {
            return null;
        }
    }
}
