package com.dm.yc.std.study.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 找出一个数组中的交集
 * Created by guobing.wei on 2016/7/13.
 */
public class Intersection2Array {


    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int p1 = 0;
        int p2 = 0;
        List list = new ArrayList();
        while(p1 < nums1.length && p2 < nums2.length) {
            if(nums1[p1] < nums2[p2]) {
                p1++;
            } else if(nums1[p1] > nums2[p2]) {
                p2++;
            } else {
                list.add(nums1[p1]);
            }
        }

        int [] res = new int[list.size()];
        for(int i = 0; i < res.length; i++) {
            res[i] = (int)list.get(i);
        }
        return res;
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
