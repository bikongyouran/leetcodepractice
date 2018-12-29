package com.mytest;

public class BinaryTreePathSum {
	class Node {
		int value;
		Node left;
		Node right;
		Node(int v) {
			value = v;
		}
	}
	
	//is there a path sum equals given value.
	public boolean hasSum(Node root, int sum) {
		if (root == null) {
			return false;
		}
		
		boolean l = false;
		boolean r = false;
		if (root.left != null) {
			l = hasSum(root.left, sum - root.value);
		} 
		if (root.right != null) {
			r = hasSum(root.right, sum - root.value);
		} 
		if (root.left == null && root.right == null){
			if (sum == root.value) {
				return true;
			} else {
				return false;
			}
		}
		return l || r;
	}

	public static void main(String[] args) {
		System.out.print("test!!");
	}
}
