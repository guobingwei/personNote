package com.study.algorithm;

/**
 * 求解n的几次幂的问题
 * Created by guobingwei on 2016/7/28.
 */
public class PowerOfN {

    // 4的n次幂
    public boolean isPowerOfFour(int num) {
        return (num > 0 ) && ((num & (num - 1)) == 0) && ((num - 1) % 3 == 0);
    }

    // 3的n次幂
    public boolean isPowerOfThree(int n) {
        return (n > 0) && (1162261467 % n == 0);
    }

    // 2的n次幂
    public boolean isPowerOfTwo(int n) {
        return n > 0 && ((n & (n - 1)) == 0);
    }


    public static void main(String [] args) {
        getMaxPowerOf(2);
    }

    /**
     * 求n在int范围内的最大次幂
     * @param  n
     */
    public static int getMaxPowerOf(int n) {
        int v = n;
        while(v > 0 && v * n > 0 && v * n <= Integer.MAX_VALUE) {
            v = v * n;
            System.out.println(v);
        }
        System.out.println("final : " + v);
        return v;
    }
}
