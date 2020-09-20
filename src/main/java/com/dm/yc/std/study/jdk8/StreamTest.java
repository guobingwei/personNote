package com.dm.yc.std.study.jdk8;

import java.util.Arrays;

/**
 * Created by guobing on 2016/8/13.
 */
public class StreamTest {

    public static void main(String[] args) {
        Arrays.asList( "a", "b", "d" ).forEach(System.out::println);
    }
}
