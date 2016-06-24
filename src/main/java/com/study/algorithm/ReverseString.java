package com.study.algorithm;

import java.lang.reflect.Array;

/**
 * 字符串反转
 * Given s = "hello", return "olleh".
 * Created by guobingwei on 2016/6/24.
 */
public class ReverseString {

    // 我想到的最传统的方法。性能很差
    public static String reverseString(String s) {
        int size = s.length();
        StringBuilder  sb = new StringBuilder();
        for(int i = size - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }

    // 通过jdk的方法实现。简单快速
    public static String reverseByJdkmethod(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    // 通过数组两头交换的方式。性能是1/2 * n
    public static String reverse2Side(String s) {
        char [] a = s.toCharArray();
        int i = 0, j = a.length - 1;
        while (i < j) {
            char tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
            i++;
            j--;
        }

        return new String(a);
    }


    public static void main(String [] args) {
        long begin = System.currentTimeMillis();
        System.out.println(reverse2Side("hello world"));
        System.out.println(System.currentTimeMillis() - begin);
    }
}
