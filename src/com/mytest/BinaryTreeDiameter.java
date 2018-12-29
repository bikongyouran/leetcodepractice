package com.mytest;

public class BinaryTreeDiameter {
	class Node {
		int value;
		Node left;
		Node right;
		Node(int v) {
			value = v;
		}
	}
	
	private int dia = 0;
	
	public int diameterOfBinaryTree(Node node) {
		if (node == null || (node.left == null && node.right == null)) {
			return 0;
		}
		getMaxDepth(node);
		return dia;
	}
	
	private int getMaxDepth(Node root) {
		if (root == null) {
			return 0;
		}
		int left = getMaxDepth(root.left);
		int right = getMaxDepth(root.right);
		
		dia = Math.max(dia, left + right);
		return Math.max(left,right) + 1;
	}
}
