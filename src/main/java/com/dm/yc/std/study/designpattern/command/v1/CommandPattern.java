package com.dm.yc.std.study.designpattern.command.v1;

/**
 * 使用 Broker 类来接受并执行命令。
 * Created by guobing on 2016/4/26.
 */
public class CommandPattern {
    public static void main(String [] args) {
        Stock stock = new Stock();

        BuyStock buyStock = new BuyStock(stock);
        SellStock sellStock = new SellStock(stock);

        Broker broker = new Broker();
        broker.takeOrder(buyStock);
        broker.takeOrder(sellStock);

        broker.placeOrder();
    }
}
