package com.dm.yc.std.study.algorithm;

/**
 * 二叉树的相关算法问题
 * Created by guobing on 2016/6/26.
 */
public class BinaryTree {

    // 树节点
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    // 求最大深度
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return 1+Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
