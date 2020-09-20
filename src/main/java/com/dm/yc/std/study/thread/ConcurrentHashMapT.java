package com.dm.yc.std.study.thread;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by guobing on 2016/2/29.
 */
public class ConcurrentHashMapT {
    public static void  main(String [] args) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("allen", 24);
        System.out.println(concurrentHashMap.get("allen"));
        String str = "abc";
        str.hashCode();
    }
}
