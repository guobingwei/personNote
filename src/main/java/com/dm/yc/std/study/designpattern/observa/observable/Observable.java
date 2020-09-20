package com.dm.yc.std.study.designpattern.observa.observable;

/**
 * Created by guobingwei on 18/5/18.
 */

import com.dm.yc.std.study.designpattern.observa.observer.Observer;

/***
 * 被观察者
 */
public interface Observable {

    // 增加一个观察者
    void addObserver(Observer observer);

    // 删除一个观察者
    void deleteObServer(Observer observer);

    // 通知观察者
    void notifyObservers(String context);
}
