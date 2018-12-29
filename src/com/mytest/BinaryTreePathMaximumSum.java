package com.mytest;

public class BinaryTreePathMaximumSum {
	class Node {
		int value;
		Node left;
		Node right;
		Node(int v) {
			value = v;
		}
	}
	
	private int max = Integer.MIN_VALUE;
	
	//https://leetcode.com/problems/binary-tree-maximum-path-sum
	public int maxPathSum(Node root) {
        helper(root);
        return max;
    }
	
	private int helper(Node root) {
		if (root == null) {
			return 0;
		}
		
		int left = Math.max(0, helper(root.left));
		int right = Math.max(0, helper(root.right));
		int sum = left + right + root.value;
		max = Math.max(max, sum);
		
		return Math.max(left, right) + root.value;
	}
}
