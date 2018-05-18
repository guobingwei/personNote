package com.study.designpattern.observa.observable;

import com.study.designpattern.observa.observer.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guobingwei on 18/5/18.
 */
public class Hanfiezi implements IHanfeizi, Observable {

    private List<Observer> observerList = new ArrayList<>();

    @Override
    public void haveBreakFast() {
        System.out.println("chifan");
        this.notifyObservers("韩非子在吃饭");
    }

    @Override
    public void haveFun() {
        System.out.println("enjoy");
        this.notifyObservers("韩非子在娱乐");
    }

    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void deleteObServer(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers(String context) {
        observerList.forEach(observer -> {
            observer.update(context);
        });
    }
}
