package com.mytest;

public class BinaryTreeBST {
	//https://leetcode.com/problems/validate-binary-search-tree
	public boolean isValidBST(Node root) {
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
	
	private boolean helper(Node root, int left, int right) {
		if (root == null)
        	return true;
		return root.value > left && root.value < right && helper(root.left, left, root.value) && helper(root.right, root.value, right);
	}
}
