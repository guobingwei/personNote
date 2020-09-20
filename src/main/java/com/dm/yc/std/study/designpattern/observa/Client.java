package com.dm.yc.std.study.designpattern.observa;

import com.dm.yc.std.study.designpattern.observa.observer.Lisi;
import com.dm.yc.std.study.designpattern.observa.observer.WangSi;
import com.dm.yc.std.study.designpattern.observa.observable.Hanfiezi;
import com.dm.yc.std.study.designpattern.observa.observer.Observer;

/**
 * Created by guobingwei on 18/5/18.
 */
public class Client {



    public static void main(String[] args) {
        Observer lisi = new Lisi();
        Observer wangSi = new WangSi();

        Hanfiezi hanfiezi = new Hanfiezi();
        hanfiezi.addObserver(lisi);
        hanfiezi.addObserver(wangSi);

        hanfiezi.haveBreakFast();
    }

}
