package com.study.algorithm;

import java.util.Arrays;

/**
 * Given an array nums, write a function to move all 0's
 * to the end of it while maintaining the relative order of the non-zero elements.
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function,
 * nums should be [1, 3, 12, 0, 0].
 *
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 *
 * Created by guobing on 2016/6/24.
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        Arrays.sort(nums);
        int size = nums.length;
        int seroCount = 0;
        for(int i = 0; i < size; i++) {
            if(nums[i] != 0) {
                break;
            } else {
                seroCount ++;
            }
        }

        int i = 0;
        for(int j = seroCount; j < size; j++, i++) {
            nums[i] = nums[j];
        }

        while (i < size) {
            nums[i] = 0;
            i++;
        }
    }

    public static void main(String [] args) {
        int [] n = {0, 1, 0, 3, 12};
        new MoveZeroes().moveZeroes(n);
        for(int i = 0; i < n.length; i++) {
            System.out.print(n[i] + ", ");
        }
    }
}
