package com.dm.yc.std.study.algorithm.tree;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Created by weiguobing on 2020-10-24.   10:31
 * email : weiguobing@meituan.com
 */
public class ZigzagLevel {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	/**
	 * 二叉树锯齿形遍历
	 * @param root
	 * @return
	 */
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		traversal(root, result, 0);
		return result;
	}


	public void traversal(TreeNode node, List<List<Integer>> result, int level) {
		if (node == null) {
			return;
		}

		if (result.size() == level) {
			result.add(new ArrayList<>());
		}

		if ((level & 1) == 1) {
			result.get(level).add(0, node.val);
		} else {
			result.get(level).add(node.val);
		}

		traversal(node.left, result, level + 1);
		traversal(node.right, result, level + 1);
	}
}
