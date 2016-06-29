package com.study.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers, find if the array contains any duplicates.
 * Your function should return true if any value appears at least twice in the array,
 * and it should return false if every element is distinct.
 * Created by guobingwei on 2016/6/29.
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        /*if(nums.length <= 0) {
            return false;
        }

        int count = 1;
        int duplicate = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(count == 0) {
                duplicate = nums[i];
            } else if(nums[i] == duplicate) {
                count++;
                break;
            } else {
                count--;
            }
        }
        return count >= 2;*/

        /*Set<Integer> set = new HashSet<>();
        for(int i : nums)
            if(!set.add(i))// if there is same
                return true;
        return false;*/

        byte[] mark = new byte[150000];
        for(int i : nums) {
            int j = i / 8;
            int k = i % 8;
            int check = 1 << k;
            if ((mark[j] & check) != 0) {
                return true;
            }
            
            mark[j] |= check;
        }

        return false;
    }
}
