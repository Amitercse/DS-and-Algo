package com.amit.binaryTree;

/**
 * @author amit
 * Class to perform basic tree operations.
 */
public class TreeBasicOperations {

	/**
	 * Find the size of tree using recursion. Find size of left subtree, find size
	 * of right subtree. 
	 * Final size= 1(for root) + left subtree size+ right subtree size
	 * @param root
	 * @return
	 */
	public int sizeUsingRecursion(BinaryTreeNode root) {
		if (root == null) {
			return 0;
		} else {
			int leftCount = root.getLeft() == null ? 0 : sizeUsingRecursion(root.getLeft());
			int rightCount = root.getRight() == null ? 0 : sizeUsingRecursion(root.getRight());
			return 1 + leftCount + rightCount;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 2, 11 };
		BinaryTreeCreation treeCreation = new BinaryTreeCreation();
		BinaryTreeNode root = treeCreation.createBinaryTree(arr);
		TreeBasicOperations operations = new TreeBasicOperations();
		int size = operations.sizeUsingRecursion(root);
		System.out.println("Tree size: " + size);
	}
}
