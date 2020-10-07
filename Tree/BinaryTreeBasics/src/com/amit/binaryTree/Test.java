package com.amit.binaryTree;

/**
 * @author amit
 * Client class to invoke operations on binary tree
 */
public class Test {

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7 };
		BinaryTreeCreation binaryTreeCreation = new BinaryTreeCreation();
		// Create binary tree using array
		BinaryTreeNode root = binaryTreeCreation.createBinaryTree(array);
		BinaryTreeTraversal binaryTreeTraversal = new BinaryTreeTraversal();
		// Traverse over binary tree
		binaryTreeTraversal.traverseTree(root);
		System.out.println();
		binaryTreeTraversal.preOrderTraversalUsingRecursion(root);
	}
}
