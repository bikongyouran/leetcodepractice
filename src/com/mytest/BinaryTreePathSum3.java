package com.mytest;

public class BinaryTreePathSum3 {
	class Node {
		int value;
		Node left;
		Node right;
		Node(int v) {
			value = v;
		}
	}
	
	public int pathSum(Node root, int sum) {
		if (root == null) {
			return 0;
		}
		
		return getNodeSum(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
	}
	
	public int getNodeSum(Node root, int sum) {
		if (root == null) {
			return 0;
		}
		int count = 0;
		
		if (root.value == sum) {
			count ++;
		}
		count += getNodeSum(root.left, sum - root.value) + getNodeSum(root.right, sum - root.value);
		return count;
	}

	public static void main(String[] args) {
		System.out.print("test!!");
	}
}
