package com.study.collections;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * test
 * Created by guobing on 2016/7/2.
 */
public class LinkedHashMapTest {

    public static void main(String [] args) {

        // 按照访问顺序排序，如果没有访问记录，则还是按插入顺序排序
        LinkedHashMap map = new LinkedHashMap(16, 0.75f, true);
        map.put("guobing", "man");
        map.put("test", "man");
        map.put("test1", "man");

        map.get("test1");
        map.get("test");
        map.get("guobing");

        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
}
