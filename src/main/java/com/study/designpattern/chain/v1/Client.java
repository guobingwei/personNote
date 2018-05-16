package com.study.designpattern.chain.v1;

/**
 * Created by guobingwei on 18/5/16.
 */
public class Client {

    public static void main(String[] args) {

        // 申明所有的处理节点
        Handler handler1 = new ConcreateHandler1();
        Handler handler2 = new ConcreateHandler2();
        Handler handler3 = new ConcreteHanlder3();

        // 设置链中的处理顺序
        handler1.setNext(handler2);
        handler2.setNext(handler3);

        // 提交请求，返回结果
        Response response = handler1.handleMessage(new Request());
    }
}
