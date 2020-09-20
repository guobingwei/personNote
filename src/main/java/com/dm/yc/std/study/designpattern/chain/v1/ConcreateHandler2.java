package com.dm.yc.std.study.designpattern.chain.v1;

/**
 * Created by guobingwei on 18/5/16.
 */
public class ConcreateHandler2 extends Handler {

    // 设置自己的处理级别
    @Override
    protected Level getHandlerLevel() {
        return null;
    }

    // 定义自己的处理逻辑
    @Override
    protected Response echo(Request request) {
        return null;
    }
}
