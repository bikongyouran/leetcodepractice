package com.mytest;

public class BinaryTreePathUnivalue {
	class Node {
		int value;
		Node left;
		Node right;
		Node(int v) {
			value = v;
		}
	}
	
	private int length = 0;
	
	//https://leetcode.com/problems/longest-univalue-path/
	public int longestUnivaluePath(Node root) {
        helper(root);
        return length;
    }
	
	private int helper(Node root) {
		if (root == null) {
			return 0;
		}
		int left = 0;
		int right = 0;
		if (root.left != null && root.left.value == root.value) {
			left = helper(root.left) + 1;
		} else {
			left = 0;
		}
		if (root.right != null && root.right.value == root.value) {
			right = helper(root.right) + 1;
		} else {
			right = 0;
		}
		
		length = Math.max(length, left + right);
		return Math.max(left, right);
	}
}
