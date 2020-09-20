package com.dm.yc.std.study.algorithm;

import java.util.Arrays;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
   You may assume that the array is non-empty and the majority element always exist in the array.
 * Created by guobingwei on 2016/6/29.
 */
public class MajorityElement {

    // sort > O(nlogn) and exists bugs
    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int size = nums.length;
        if(size <= 1) {
            return nums[0];
        }

        int totalCount = 0;
        int majority = 0;
        for(int i = 0; i < size - 1; i++) {
            int count = 0;
            int j = i;
            while ( j < size - 1 && nums[j] == nums[j + 1]) {
                j++;
                count++;
            }

            if(count > totalCount) {
                totalCount = count;
                majority = nums[i];
            }
        }

        return majority;
    }

    // sort O(nlogn)
    public static int majorityElementBySort(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        return nums[len/2];
    }

    // sort by O(n)
    public static int majorityElementBest(int[] nums) {
        int major = nums[0];
        int count = 1;
        for(int i = 1; i < nums.length; i++) {
            if(count == 0) {
                count++;
                major = nums[i];
            } else if(major == nums[i]) {
                count++;
            } else {
                count--;
            }
        }

        return major;
    }

    public static void main(String [] args) {
        int [] nums = {2, 2};
        System.out.println(MajorityElement.majorityElementBest(nums));
    }
}
