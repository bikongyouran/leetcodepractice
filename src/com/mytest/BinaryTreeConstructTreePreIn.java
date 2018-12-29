package com.mytest;

public class BinaryTreeConstructTreePreIn {
	class Node {
		int value;
		Node left;
		Node right;
		Node(int v) {
			value = v;
		}
	}
	
	//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
	public Node buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length != inorder.length)
        	return null;
        return helper(0,0,inorder.length - 1, preorder, inorder);
    }
	
	private Node helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
		if (preStart > preorder.length - 1 || inStart > inEnd) {
			return null;
		}
		
		int root = preorder[preStart];
		Node rootNode = new Node(root);
		int rootIndexInorder = findRootIndexInorder(root, inorder);
		if (rootIndexInorder == -1)
			return null;
		rootNode.left = helper(preStart + 1, inStart, rootIndexInorder - 1, preorder, inorder);
		rootNode.right = helper(preStart + (rootIndexInorder - inStart) + 1, rootIndexInorder + 1, inEnd, preorder, inorder);
		return rootNode;
	}

	private int findRootIndexInorder(int root, int[] inorder) {
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == root) {
				return i;
			}
		}
		return -1;
	}
}
