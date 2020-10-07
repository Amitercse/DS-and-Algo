package com.amit.binaryTree;

/**
 * @author amit
 * Client class to invoke operations on binary tree
 */
public class Test {

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 2, 11 };
		BinaryTreeCreation binaryTreeCreation = new BinaryTreeCreation();
		// Create binary tree using array
		BinaryTreeNode root = binaryTreeCreation.createBinaryTree(array);
		BinaryTreeTraversal binaryTreeTraversal = new BinaryTreeTraversal();
		System.out.println("BFS traversal over tree");
		binaryTreeTraversal.traverseTree(root);
		System.out.println("\nPre order traverse using recursion");
		binaryTreeTraversal.preOrderTraversalUsingRecursion(root);
		System.out.println("\nPre order traverse using iteration");
		binaryTreeTraversal.preorderTraversalUsingIteration(root);
		System.out.println("\nInorder traversal using recursion");
		binaryTreeTraversal.inorderTraversalUsingRecursion(root);
		System.out.println("\nInorder traversal using iteration");
		binaryTreeTraversal.inorderTraversalUsingIteration(root);
	}
}
