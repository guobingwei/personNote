package com.study.algorithm;

/**
 * 斐波那契数列问题
 * 关心两个问题：
 * 1. 返回斐波那契数列第 n 项的函数，
 * 2. 以及如何在 Java 中用递归解决这个问题
 * Created by guobing on 2016/8/5.
 */
public class Fibonacci {

    // 返回第n项的斐波那契数 递归. 有一条定律：永远不要用递归代替简单的循环. 重复计算了f(n-2)
    public int getFib(int n) {
        if(n <= 2) {
            return 1;
        }

        return  getFib(n - 1) + getFib(n - 2);
    }

    public int fib(int n) {
        long begin = System.currentTimeMillis();
        if(n <= 2) {
            return 1;
        }

        int result = 0;
        int first = 0;
        int second = 1;
        for (int i = 1; i < n; i++) {
            result = first + second;
            first = second;
            second = result;
        }
        System.out.println("执行耗时：" + (System.currentTimeMillis() - begin));
        return result;
    }

    public static void main(String [] args) {
        System.out.println(new Fibonacci().fib(50));

        long begin = System.currentTimeMillis();
        int n = new Fibonacci().getFib(50);
        long diff = System.currentTimeMillis() - begin;
        System.out.println("递归用时：" + diff + ", - value : " + n);
    }
}
