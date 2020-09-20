package com.dm.yc.std.study.collections;

import java.util.HashSet;
import java.util.Set;

/**
 * hashSet
 * Created by guobing on 2016/7/2.
 */
public class HashSetTest {
    public static void main(String [] args) {
        HashSet set = new HashSet();
        set.add("guobing");
        set.add("innohub");
        set.add("innohub1");
        set.contains("innohub");
    }
}
