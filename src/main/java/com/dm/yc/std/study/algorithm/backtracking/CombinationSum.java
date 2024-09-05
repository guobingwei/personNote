package com.dm.yc.std.study.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1：
 * <p>
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为： [ [7], [2,2,3] ]
 * 示例 2：
 * <p>
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为： [ [2,2,2,2], [2,3,3], [3,5] ]
 */
public class CombinationSum {


    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        int[] candidates = new int[]{2, 3, 4, 5};
        List<List<Integer>> lists = combinationSum.combinationSum(candidates, 4);
        System.out.println(lists);
    }

    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates); // 先进行排序
        backtracking(res, candidates, target, 0, 0);
        return res;
    }

    /**
     * 输入：candidates = [2,3,6,7], target = 7,
     * 所求解集为： [ [7], [2,2,3] ]
     *
     * @param res
     * @param candidates
     * @param target
     * @param index
     * @param sum
     */
    public void backtracking(List<List<Integer>> res, int[] candidates, int target, int index, int sum) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] + sum > target) {
                return;
            }

            path.add(candidates[i]);
            backtracking(res, candidates, target, i, sum + candidates[i]);
            path.remove(path.size() - 1);
        }
    }
}
