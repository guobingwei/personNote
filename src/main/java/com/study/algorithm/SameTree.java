package com.study.algorithm;

/**
 * Given two binary trees, write a function to check if they are equal or not.
 * Created by guobing on 2016/6/26.
 */
public class SameTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    // is same tree ?
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }

        if(p == null || q == null) {
            return false;
        }

        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
