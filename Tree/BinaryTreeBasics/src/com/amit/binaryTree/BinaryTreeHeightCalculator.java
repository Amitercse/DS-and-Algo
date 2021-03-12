package com.amit.binaryTree;

public class BinaryTreeHeightCalculator {

	/*
	 * For empty tree height will be -1
	 */
	public int getHeight(BinaryTreeNode root) {
		if (root == null) {
			/*
			 * Returning -1 because every time we are calculating depth I am adding one. So
			 * compensating in the end.
			 */
			return -1;
		} else {
			int ldepth = getHeight(root.getLeft());
			int rdepth = getHeight(root.getRight());
			return Math.max(ldepth, rdepth) + 1;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		BinaryTreeCreation creation = new BinaryTreeCreation();
		BinaryTreeNode root = creation.createBinaryTree(arr);
		BinaryTreeHeightCalculator binaryTree = new BinaryTreeHeightCalculator();
		int height= binaryTree.getHeight(root);
		System.out.println("height: "+ height);
	}
}
