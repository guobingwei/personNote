package com.dm.yc.std.study.algorithm;

/**
 * 判断一个数是不是丑数
 * Created by guobing on 2016/6/26.
 */
public class UglyNumber {

    // 原来这么写，没想到！脑子不行啊
    public static boolean isUgly(int num) {
        if(num == 1) {
            return true;
        }

        if(num <= 0) {
            return false;
        }

        while (num % 2 == 0) {
            num = num >> 1;
        }

        while (num % 3 == 0 ) {
            num /= 3;
        }

        while (num % 5 == 0) {
            num /= 5;
        }

        return num == 1;
    }

    public static boolean isUglySimple(int num) {
        for (int i=2; i<6 && num>0; i++)
            while (num % i == 0)
                num /= i;
        return num == 1;
    }
}
