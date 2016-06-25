package com.study.algorithm;

/**
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2.
 * Since 2 has only one digit, return it.
 * Created by guobingwei on 2016/6/24.
 */
public class AddDigits {

    // 这么简洁，我没想出来……
    public int addDigits(int num) {
        int res = num % 9;
        return (res != 0 || num == 0) ? res : 9;
    }

    // 最传统的做法，循环相加
    public static int addDigitsByNormal(int num) {

        while (num / 10 > 0) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }

            num = sum;
        }

        return num;
    }

    public static void main(String [] args) {
        System.out.print(new AddDigits().addDigits(19));
    }
}
