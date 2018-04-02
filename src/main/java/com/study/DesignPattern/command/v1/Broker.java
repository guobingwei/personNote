package com.study.DesignPattern.command.v1;

import java.util.ArrayList;
import java.util.List;

/**
 * 中介者
 * Created by guobing on 2016/4/26.
 */
public class Broker {
    List<Order> orderList = new ArrayList<Order>();

    public void takeOrder(Order order) {
        orderList.add(order);
    }

    public void placeOrder() {
        for(Order order : orderList) {
            order.excute();
        }

        orderList.clear();
    }
}
