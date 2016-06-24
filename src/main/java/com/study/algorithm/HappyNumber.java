package com.study.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * HappyNumber
 * Created by guobingwei on 2016/6/24.
 */
public class HappyNumber {

    /**
     * 思路：先循环求出各个位的平方和，然后利用set的去重功能，判断是不是重新循环了
     * function：判断是不是快乐数
     * @param n
     * @return
     */
    public static boolean isHappy(int n) {
        Set set = new HashSet<>();
        boolean isHappy = false;

        while (true) {

            // 先求各个位的平方和
            int sum = 0;
            while (n > 0) {
                int e = 0;
                e = n % 10;
                sum += e * e;
                n /= 10;
            }

            if(sum == 1) {
                isHappy = true;
                break;
            }

            int beginSize = set.size();

            set.add(sum);

            int endSize = set.size();

            if(beginSize == endSize) {
                isHappy = false;
                break;
            }

            n = sum;
        }

        return isHappy;
    }

    /**
     * 网上看的，非快乐数有个特点，循环的数字中必定会有4
     * @param n
     * @return
     */
    public static boolean isHappyBy4(int n) {
        while (n != 1 && n != 4) {
            int t = 0;
            while (n > 0) {
                t += (n % 10) * (n % 10);
                n /= 10;
            }
            n = t;
        }
        return n == 1;
    }

    /**
     * 这个方法直接判断是不是contains，然后加或者不加。用size判断的话进行了一次add，效率没有提高
     * @param n
     * @return
     */
    public static boolean isHappyNosize(int n) {

        Set set = new HashSet();
        while (n != 1) {
            int s = 0;
            while (n > 0) {
                s += (n % 10) * (n % 10);
                n /= 10;
            }

            n = s;

            if(set.contains(s))
                break;
            else
                set.add(s);

        }
        return n == 1;
    }

    public static void main(String [] args) {
        long begin = System.currentTimeMillis();
        System.out.println(isHappyNosize(2));
        System.out.println(System.currentTimeMillis() - begin);
    }
}
