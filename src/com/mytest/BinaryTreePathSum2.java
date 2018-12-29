package com.mytest;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePathSum2 {
	class Node {
		int value;
		Node left;
		Node right;
		Node(int v) {
			value = v;
		}
	}
	
	public List<List<Integer>> getPath(Node root, int sum) {
		List<List<Integer>> results = new ArrayList<>();
		if (root == null) {
			return null;
		}
		List<Integer> path = new ArrayList<>();
		hasSum(root, sum, path, results);
		return results;
	}
	
	//find all paths sum equals given value.
	public void hasSum(Node root, int sum, List<Integer> path, List<List<Integer>> results) {
		if (root == null) {
			return;
		}
		path.add(root.value);
		if (root.left == null && root.right == null){
			if (sum == root.value) {
				results.add(new ArrayList<>(path));//copy the path each time.
			} 
		}
		hasSum(root.left, sum-root.value, path, results);
		hasSum(root.right, sum-root.value, path, results);
		path.remove(path.size() - 1);
	}

	public static void main(String[] args) {
		System.out.print("test!!");
	}
}
