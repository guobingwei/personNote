package com.dm.yc.std.study.algorithm;

/**
 * Created by guobingwei on 2016/7/5.
 */
public class FindFriends {
    public static void main(String [] args) {
        int [] arr = new int [] {8, 3, 0, 9, 1, 4, 2, 6};
        int [] index = new int[] {4, 1, 6, 1, 7, 3, 1, 5, 2, 6, 0};
        String tel = "";
        for(int i: index) {
            tel += arr[i];
        }
        System.out.print(tel);
    }
}
