package com.study.designpattern.observa;

import com.study.designpattern.observa.observer.WangSi;
import com.study.designpattern.observa.observable.Hanfiezi;
import com.study.designpattern.observa.observer.Observer;

/**
 * Created by guobingwei on 18/5/18.
 */
public class Client {



    public static void main(String[] args) {
        Observer lisi = new com.study.designpattern.observa.observer.Lisi();
        Observer wangSi = new WangSi();

        Hanfiezi hanfiezi = new Hanfiezi();
        hanfiezi.addObserver(lisi);
        hanfiezi.addObserver(wangSi);

        hanfiezi.haveBreakFast();
    }

}
