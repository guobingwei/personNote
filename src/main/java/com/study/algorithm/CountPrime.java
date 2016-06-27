package com.study.algorithm;

/**
 * 计算小于一个非负整数的素数个数
 *
 * 若 n=a b 是个合数（其中 a 与 b ≠ 1）, 则其中一个约数 a 或 b 必定至大为  sqrt {n}
 * Created by guobing on 2016/6/26.
 */
public class CountPrime {

    // 尼玛，没看懂啊，啥意思？？
    public int countPrimes(int n) {
        boolean[] m = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (m[i])
                continue;

            count++;
            for (int j = i; j < n; j = j + i)
                m[j] = true;
        }

        return count;
    }

    // 埃拉托斯特尼筛法 时间 O(NloglogN) 空间 O(N)
    public int countPrimes2(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i * j < n; j++) {
                    notPrime[i * j] = true;
                }
            }
        }

        return count;
    }

    public static boolean isPrime(int n) {
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if((n % i) == 0) {
                return false;
            }
        }
        return true;
    }

    // 根据埃拉托斯特尼筛法算法思路自己写一遍
    public static int countPrime(int n) {
        int count = 0;
        boolean [] notPrime = new boolean[n];
        for(int i = 2; i < n; i++) {
            if(!notPrime[i]) {
                count++;
            }

            for(int j = i; j * i < n; j++) {
                notPrime[j * i] = true;
            }
        }

        return count;
    }

    public static void main(String [] args) {
        System.out.println(new CountPrime().countPrimes(15));
        System.out.println(new CountPrime().countPrimes2(15));
        System.out.println(CountPrime.isPrime(7));
    }
}
