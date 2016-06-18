package com.study.algorithm;

import java.util.*;

/**
 * Given an array S of n integers, find three integers in S such that the sum
 * is closest to a given number, target. Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.
 *
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * Created by guobing on 2016/6/18.
 */
public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        int result = 0;
        int size = nums.length;
        if(size >= 3) {
            // 先把每一项和diff放在一个map中
            List list = new ArrayList();
            Map r = new HashMap();
            for(int n : nums) {
                r.put("num", n);
                r.put("diff", Math.abs(target - n));
                list.add(r);
            }

            // 对相减的结果排序
            Collections.sort(list);
            /*Collections.sort(list, new Comparator<Map>() {
                @Override
                public int compare(Object o1, Object o2) {
                    return 0;
                }
            });*/
        }

        int [] sel = new int[3];
        for(int n : sel) {
            result += n;
        }

        return result;
    }

   /* Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
            return (o2.getValue() - o1.getValue());
        }
    });*/

    public static void main(String [] args) {
        int [] nums = {-1, 2, 1, -4};
        int target = 1;
        int r = threeSumClosest(nums, target);
        System.out.print(r);
    }
}
