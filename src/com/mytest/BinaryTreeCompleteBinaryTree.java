package com.mytest;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeCompleteBinaryTree {
	public boolean isCBT(Node root) {
		if (root == null) 
			return true;
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(root);
		boolean isLeaf = false;
		
		while (!queue.isEmpty()){
			Node node = queue.poll();
			Node left = node.left;
			Node right = node.right;
			if (isLeaf && (left != null || right != null)) {
				return false;
			}
			
			if (right != null && left == null) {
				return false;
			}
			
			if (left != null) {
				queue.offer(left);
			}
			if (right != null) {
				queue.offer(right);
			} else {
				isLeaf = true;
			}
		}
		return true;
	}
}
