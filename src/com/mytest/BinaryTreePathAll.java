package com.mytest;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePathAll {
	class Node {
		int value;
		Node left;
		Node right;
		Node(int v) {
			value = v;
		}
	}
	
	public List<String> getAllPaths(Node root) {
		List<String> results = new ArrayList<String>();
		if (root == null) {
			return results;
		}
		
		helper(root, root.value + "", results);
		return results;
	}
	
	public void helper(Node root, String path, List<String> results) {
		if (root == null) {
			return;
		}
	
		if (root.left == null && root.right == null) {
			results.add(path);
		}
		if (root.left != null) {
			helper(root.left, path + "->" + root.left.value, results);
		}
		if (root.right != null) {
			helper(root.right, path + "->" + root.right.value, results);
		}
	}
}
