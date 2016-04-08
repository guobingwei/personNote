package com.study.thread;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by guobing on 2016/2/29.
 */
public class ConcurrentHashMapT {
    public static void  main(String [] args) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("allen", 24);
        String str = "abc";
        str.hashCode();
    }
}
