package com.mytest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryTreePathValueLessThanCurValue {
//	private static int count = 0;
	
	public int validPath(Node root) {
		if (root == null)
			return 0;
		List<Integer> path = new ArrayList<Integer>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("count", 0);
		helper(root, map, path);
		return map.get("count");
	}

	private void helper(Node root, Map<String, Integer> map, List<Integer> path) {
		if (root == null)
			return;
		boolean isValidPath = true;
		if (path.size() > 0) {
			for (int i = 0; i < path.size(); i++) {
				if (path.get(i) > root.value) {
					isValidPath = false;
				}
			}
		}
		if (isValidPath) {
			int count = map.get("count");
			count ++;
			map.put("count", count);
		}
		path.add(root.value);
		helper(root.left, map, path);
		helper(root.right, map, path);
		path.remove(path.size() - 1);
	}
	
	public static void main(String[] args) {
		BinaryTreeSerializeDeserialize sd = new BinaryTreeSerializeDeserialize();
		String tree = "8!2!6!8!7!5!#!#!#!#!#!#!#!";
//		String tree = "1!2!3!#!4!5!#!#!#!#!#!";//5
		Node root = sd.deserializeByLevel(tree);
		
		BinaryTreePathValueLessThanCurValue cv = new BinaryTreePathValueLessThanCurValue();
		int count = cv.validPath(root);
		System.out.println(count);
	}
}
