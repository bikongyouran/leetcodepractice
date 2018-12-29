package com.mytest;

public class BinaryTreeBalanced {
	//https://leetcode.com/problems/balanced-binary-tree
	public boolean isBalanced(Node root) {
        if (root == null)
        	return true;
        int left = depth(root.left);
        int right = depth(root.right);
        return Math.abs(left - right) < 2 && isBalanced(root.left) && isBalanced(root.right);
    }
	
	private int depth(Node root) {
		if (root == null) 
			return 0;
		return Math.max(depth(root.left), depth(root.right)) + 1;
	}
}