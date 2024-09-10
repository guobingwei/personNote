package com.dm.yc.std.study.algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PartitionStr {
    /**
     * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文串
     * 返回 s 所有可能的分割方案。
     * 示例 1：
     * 输入：s = "aab"
     * 输出：[["a","a","b"],["aa","b"]]
     */

    List<List<String>> result = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backTracking(s, 0, new StringBuilder());
        return result;
    }

    public void backTracking(String s, int index, StringBuilder sb) {
        if (index == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            sb.append(s.charAt(index));
            String substring = s.substring(index, i + 1);

            if (check(substring)) {
                path.add(substring);
                backTracking(s, i + 1, new StringBuilder());
                path.remove(path.size() - 1);
            }
        }
    }

    public boolean check(String sb) {
        for (int i = 0; i < sb.length() / 2; i++) {
            if (sb.charAt(i) != sb.charAt(sb.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PartitionStr partitionStr = new PartitionStr();
        List<List<String>> res = partitionStr.partition("aab");
        System.out.println(res);
    }
}
