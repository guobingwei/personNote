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

    /**
     *  这个是求三个与目标数最接近的和。和题意不符！
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {
        int size = nums.length;
        if(size <= 3) {
            int sum = 0;
            for(int n : nums) {
                sum += n;
            }
            return sum;
        }

        combine(nums, 3, target);
        Collections.sort(list, new Comparator<Map<String,Integer>>(){
            public int compare(Map<String, Integer> o1, Map<String, Integer> o2) {
                //取出操作时间
                int ret = 0;
                ret = o1.get("diff").compareTo(o2.get("diff"));
                return  ret;
            }
        });

        Map one = (Map)list.get(0);
        return (int)one.get("num");
    }

    public static List list = new ArrayList();

    /**
     * 功能：找出与target最接近的三个数,求和
     * @param nums 目标数组
     * @param target 目标元素
     * @return 符合条件的三个数字之和
     */
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

    public static void combine(int[] a, int n, int target) {
        if(null == a || a.length == 0 || n <= 0 || n > a.length)
            return;

        // 辅助空间，保存待输出组合数
        int[] b = new int[n];
        getCombination(a, n , 0, b, 0, target);
    }

    /**
     * 排列组合问题
     * @param a 数组
     * @param n 数组长度
     * @param begin 开始排序的数
     * @param b 保存组合数的数组
     * @param index
     */
    private static void getCombination(int[] a, int n, int begin, int[] b, int index, int target) {

        // 如果够n个数了，输出b数组
        if(n == 0){
            int sum = 0;
            for(int i = 0; i < index; i++){
                sum += b[i];
                System.out.print(b[i] + " ");
            }

            Map r = new HashMap();
            r.put("num", sum);
            r.put("diff", Math.abs(target - sum));
            list.add(r);
            System.out.println();
            return;
        }

        for(int i = begin; i < a.length; i++){

            b[index] = a[i];
            getCombination(a, n-1, i+1, b, index+1, target);
        }
    }

    // 简洁的求法，先排序 O(n2)
    public static int closest(int[] nums, int target) {
        int min = Integer.MAX_VALUE;

        Arrays.sort(nums);

        int size = nums.length;
        int result = 0;

        for(int i = 0; i < size; i++) {
            int l = i + 1;
            int r = size - 1;

            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                int diff = Math.abs(sum - target);
                if(diff == 0) {
                    return target;
                }

                if(diff < min) {
                    min = diff;
                    result = sum;
                }

                if (sum <= target) {
                    l++;
                } else {
                    r--;
                }
            }
        }

        return result;
    }

    public static void main(String [] args) {
        int [] nums = {1, 1, 1, 0};
        int target = 100;
        int r = closest(nums, target);
        System.out.print(r);
    }
}
