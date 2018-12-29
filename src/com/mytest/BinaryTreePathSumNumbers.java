package com.mytest;

public class BinaryTreePathSumNumbers {
	class Node {
		int value;
		Node left;
		Node right;
		Node(int v) {
			value = v;
		}
	}
	
	//https://leetcode.com/problems/sum-root-to-leaf-numbers
	public int sumNumbers(Node root) {
		return helper (root, 0);
	}
	
	public int helper(Node root, int sum) {
		if (root == null) {
			return 0;
		}
		
		if (root.left == null && root.right == null) {
			return sum*10 + root.value;
		}
		return helper(root.left, sum*10 + root.value) + helper(root.right, sum*10 + root.value);
	}
}
