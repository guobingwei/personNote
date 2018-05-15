package com.study.designpattern.command.v1;

/**
 * Created by guobing on 2016/4/26.
 */
public class SellStock implements Order {
    private Stock stock;

    public SellStock(Stock stock) {
        this.stock = stock;
    }
    @Override
    public void excute() {
        stock.sell();
    }
}
