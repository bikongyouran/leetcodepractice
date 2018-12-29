package com.mytest;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeSerializeDeserialize {
	
	private static final String spliter = "!";
	private static final String NullNode = "#";
	
	public String serializeByPre(Node node) {
		if (node == null)
			return NullNode + spliter;
		String res = node.value + spliter;
		res += serializeByPre(node.left);
		res += serializeByPre(node.right);
		return res;
	}
	
	public Node deserializeByPre(String tree) {
		if (tree == null)
			return null;
		String[] values = tree.split(spliter);
		Queue<String> queue = new LinkedList<String>();
		for (int i = 0; i < values.length; i++) {
			queue.offer(values[i]);
		}
		return reconPreOrder(queue);
	}

	private Node reconPreOrder(Queue<String> queue) {
		String value = queue.poll();
		if (value.equals(NullNode)) {
			return null;
		}
		Node root = new Node(Integer.valueOf(value));
		root.left = reconPreOrder(queue);
		root.right = reconPreOrder(queue);
		return root;
	}
	
	public String serializeByLevel(Node node) {
		if (node == null) 
			return NullNode + spliter;
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(node);
		String res = node.value + spliter;
		while (!queue.isEmpty()) {
			Node n = queue.poll();
			if (n.left == null) {
				res += NullNode + spliter;
			} else {
				queue.offer(n.left);
				res += n.left.value + spliter;
			}
			if (n.right == null) {
				res += NullNode + spliter;
			} else {
				queue.offer(n.right);
				res += n.right.value + spliter;
			} 
		}
		return res;
	}
	
	public Node deserializeByLevel(String tree) {
		if (tree == null)
			return null;
		String[] values = tree.split(spliter);
		if (values[0].equals(NullNode))
			return null;
		Queue<Node> queue = new LinkedList<Node>();
		Node head = new Node(Integer.valueOf(values[0]));
		queue.offer(head);
		int index = 1;
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			node.left = constructNode(values[index++]);
			node.right = constructNode(values[index++]);
			if (node.left != null)
				queue.offer(node.left);
			if (node.right != null)
				queue.offer(node.right);
		}
		
		return head;
	}
	
	private Node constructNode(String val) {
		if (val.equals(NullNode))
			return null;
		return new Node(Integer.valueOf(val));
	}
	
	public static void main(String[] args) {
		BinaryTreeSerializeDeserialize sd = new BinaryTreeSerializeDeserialize();
		String tree = "1!2!3!#!4!5!#!#!#!#!#!";
		String tree2 = "1!2!#!4!#!#!3!5!#!#!#!";
		
		Node root = sd.deserializeByLevel(tree);
		Node root2 = sd.deserializeByPre(tree2);
		String rs2 = sd.serializeByLevel(root2);
		String rs = sd.serializeByPre(root);
		System.out.println("rs:" +rs);
		System.out.println("rs2:" +rs2);
	}
}
