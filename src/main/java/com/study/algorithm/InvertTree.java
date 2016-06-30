package com.study.algorithm;

/**
 *           4
 *         /    \
 *        2     7
 *        / \   / \
 *       1  3 6   9
 *    to
 *          4
 *        /   \
 *       7     2
 *      / \   / \
 *     9  6  3   1
 * Created by guobing on 2016/6/26.
 */
public class InvertTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 根据对称性反转，递归
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        final TreeNode left = root.left,
                right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }

    /**
     * 非递归, 用循环 no no no~ 这还是递归
     */
    public void Mirror(TreeNode root) {
        if(root != null){
            Mirror(root.left);
            Mirror(root.right);
            TreeNode temp = root.left;
            root.left=root.right;
            root.right = temp;
        }
    }
}
