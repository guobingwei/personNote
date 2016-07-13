package com.study.algorithm;

import java.util.HashMap;

/**
 * 找出一个数组中的交集
 * Created by guobing.wei on 2016/7/13.
 */
public class Intersection2Array {


    public int[] intersect(int[] nums1, int[] nums2) {
        int len = nums1.length > nums2.length ? nums1.length : nums2.length;
        int [] result = new int[len];
        if(nums1.length <= 0 || nums2.length <= 0) {
            return result;
        }

        HashMap map = new HashMap();
        for(int i = 0; i < nums1.length; i++) {

        }
        return result;
    }

    public static void  main(String [] args) {
        int [] nums1 = {1};
        int [] nums2 = {0};
        int [] r = new Intersection2Array().intersect(nums1, nums2);
        for(int i : r ) {
            System.out.println(i);
        }
    }
}
