package com.study.algorithm;

import java.text.ParseException;
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

    /**
     *这个是求三个与目标数最接近的和。和题意不符！
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {
        int size = nums.length;
        if(size < 3) {
            return 0;
        }

        int c1 = 0, c2 = 1, c3 = 2;
        List list = new ArrayList();
        while (c1 <= size - 3) {
            int s = nums[c1] + nums[c2] + nums[c3];
            list.add(s);
            if(c3 == size - 1) {
                c1++;
                c2++;
                c3 = c2 + 1;
            } else {
                c3++;
            }
        }

        List diffList = new ArrayList();
        for(int i = 0; i < list.size(); i++) {
            Map<String, Integer> r = new HashMap<>();
            r.put("num", (int)list.get(i));
            r.put("diff", Math.abs(target - (int)list.get(i)));
            diffList.add(r);
        }

        Collections.sort(diffList, new Comparator<Map<String,Integer>>(){
            public int compare(Map<String, Integer> o1, Map<String, Integer> o2) {
                //取出操作时间
                int ret = 0;
                ret = o1.get("diff").compareTo(o2.get("diff"));
                return  ret;
            }
        });

        Map one = (Map)diffList.get(0);
        return (int)one.get("num");
    }

    public static int closestTarget(int[] nums, int target) {
        int result = 0;
        int size = nums.length;
        if(size >= 3) {
            // 先把每一项和diff放在一个map中
            List list = new ArrayList();
            for(int n : nums) {
                Map r = new HashMap();
                r.put("num", n);
                r.put("diff", Math.abs(target - n));
                list.add(r);
            }

            // 对相减的结果排序
            Collections.sort(list, new Comparator<Map<String,Integer>>(){
                public int compare(Map<String, Integer> o1, Map<String, Integer> o2) {
                    //取出操作时间
                    int ret = 0;
                    ret = o1.get("diff").compareTo(o2.get("diff"));
                    return  ret;
                }
            });

            list = list.subList(0, 3);
            Iterator<Map> iter = list.iterator();

            while(iter.hasNext()) {
                Map<String, Integer> one = iter.next();
                result += one.get("num");
            }

        } else {
            for(int i : nums) {
                result += i;
            }
        }

        return result;
    }

    public static void main(String [] args) {
        int [] nums = {1, 2, 4, 8, 16, 32, 64, 128};
        int target = 1;
        int r = threeSumClosest(nums, target);
        System.out.print(r);
    }
}
