package com.mytest;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeUtils {
	private static final String spliter = "!";
	private static final String NullNode = "#";
	
	public static String serializeByPre(Node node) {
		if (node == null)
			return NullNode + spliter;
		String res = node.value + spliter;
		res += serializeByPre(node.left);
		res += serializeByPre(node.right);
		return res;
	}
	
	public static Node deserializeByPre(String tree) {
		String[] values = tree.split(spliter);
		Queue<String> queue = new LinkedList<String>();
		for (int i = 0; i < values.length; i++) {
			queue.offer(values[i]);
		}
		return reconPreOrder(queue);
	}

	private static Node reconPreOrder(Queue<String> queue) {
		String value = queue.poll();
		if (value.equals(NullNode)) {
			return null;
		}
		Node root = new Node(Integer.valueOf(value));
		root.left = reconPreOrder(queue);
		root.right = reconPreOrder(queue);
		return root;
	}
}
