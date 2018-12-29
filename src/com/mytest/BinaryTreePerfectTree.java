package com.mytest;

//have 2 solutions implementation for this!!
public class BinaryTreePerfectTree {
	public boolean isPerfectTree (Node root) {
		//1. find the leaf depth, all leaf are in the same depth; 2. all internal nodes have 2 children.
		if (root == null) 
			return true;
		int depth = 0;
		Node temp = root;
		while (temp != null) {
			temp = temp.left;
			depth ++;
		}
		
		return helper(root,depth,0);
	}
	
	private boolean helper (Node node, int depth, int level) {
		if (node == null)
			return true;
		if (node.left == null && node.right == null) {
			return depth == level + 1;
		}
		if (node.left == null || node.right == null) {
			return false;
		}
		return helper(node.left,depth,level+1) && helper(node.right,depth,level+1);
	}
	
	public boolean isPerfectTree2 (Node root) {
		//for all nodes, left and right height are same.
		if (root == null)
			return true;
		int left = depth(root.left);
		int right = depth(root.right);
		if (left != right) {
			return false;
		}
		return isPerfectTree2(root.left) && isPerfectTree2(root.right);
	}
	
	private int depth (Node root) {
		if (root == null)
			return 0;
		int left = depth(root.left);
		int right = depth(root.right);
		return Math.max(left, right) + 1;
	}
	
	public static void main(String[] args) {
		BinaryTreeSerializeDeserialize sd = new BinaryTreeSerializeDeserialize();
//		String tree = "1!2!3!4!5!6!#!#!#!#!#!#!#!";
//		String tree = "1!2!3!4!5!#!#!#!#!#!#!";
//		String tree = "1!2!3!6!4!5!7!#!#!#!#!#!#!#!#!";//true
		String tree = "1!2!3!#!4!5!#!#!#!#!#!";
		Node root = sd.deserializeByLevel(tree);
//		String rs = sd.serializeByPre(root);
//		System.out.println("rs:" +rs);
		
		BinaryTreePerfectTree pt = new BinaryTreePerfectTree();
		boolean res = pt.isPerfectTree2(root);
		System.out.println("res:" +res);
	}
}
