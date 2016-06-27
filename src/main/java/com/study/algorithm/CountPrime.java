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

    public static void main(String [] args) {
        new CountPrime().countPrimes2(10);
        System.out.print(CountPrime.isPrime(7));
    }
}
