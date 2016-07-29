package com.study.algorithm;

/**
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed, the only constraint
 * stopping you from robbing each of them is that adjacent houses have
 * security system connected and it will automatically contact the police
 * if two adjacent houses were broken into on the same night.
 *
 *  Given a list of non-negative integers representing the amount of money of
 *  each house, determine the maximum amount of money you can rob tonight without alerting the police.
 * Created by guobingwei on 2016/7/29.
 */
public class HouseRobber {

    /**
     * rob adjacent houses will alerting the police
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        // max monney can get if rob current house
        int rob = 0;
        // max money can get if not rob current house
        int notrob = 0;
        for(int i=0; i < nums.length; i++) {
            // if rob current value, previous house must not be robbed
            int currob = notrob + nums[i];
            // if not rob ith house, take the max value of robbed (i-1)th house and not rob (i-1)th house
            notrob = Math.max(notrob, rob);
            rob = currob;
        }
        return Math.max(rob, notrob);
    }

    /**
     * 一種我比較好理解的方法
     * 網站鏈接: https://segmentfault.com/a/1190000003811581
     * @param nums
     * @return
     */
    public int robEasy(int[] nums) {
        if(nums.length <= 1) {
            return nums.length == 0 ? 0 : nums[0];
        }

        int a = nums[0];
        int b = Math.max(a, nums[1]);

        for(int i = 2; i < nums.length; i++) {
            int tmp = b;
            b = Math.max(a + nums[i], b);
            a = tmp;
        }

        return b;
    }

    /**
     * hours rob 升級版問題
     * 搶了第一間房就不能搶最後一間房
     * 搶了最後一間房就不能搶第一間房
     * @param nums
     * @return
     */
    public int rob2(int[] nums) {
        if(nums.length <= 1) {
            return nums.length == 0 ? 0 : nums[0];
        }

        int a = nums[0];
        int b = Math.max(a, nums[1]);

        for(int i = 2; i < nums.length; i++) {
            int tmp = b;
            b = Math.max(a + nums[i], b);
            a = tmp;
        }

        return b;
    }
}
