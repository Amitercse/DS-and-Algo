/**
 * 
 */
package com.amit.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Class to create binary tree.
 * @author amit
 */
public class BinaryTreeCreation {

	private BinaryTreeNode root;
	
	/**
	 * Using array as input to create binary tree.
	 * It needs time complexity O(n) to traverse the array and
	 * space complexity of O(n) for queue.
	 * @author amit
	 * @param inputArr
	 * @return
	 */
	public BinaryTreeNode createBinaryTree(int[] inputArr) {
		root = new BinaryTreeNode();
		root.setData(inputArr[0]);
		/*
		 * Using queue to maintain the nodes list. For each element we need to 
		 * create its left and right child and then for left and right child need 
		 * to do the same. Using queue as it provides FIFO operation.
		 */
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		BinaryTreeNode currentNode = root;
		for (int i = 1; i < inputArr.length; i++) {
			BinaryTreeNode newNode = new BinaryTreeNode();
			newNode.setData(inputArr[i]);
			queue.offer(newNode);
			if (currentNode.getLeft() == null) {
				currentNode.setLeft(newNode);
			} else if (currentNode.getRight() == null) {
				currentNode.setRight(newNode);
			} else {
				currentNode = queue.poll();
				currentNode.setLeft(newNode);
			}
		}
		return root;
	}
	
	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 2, 11 };
		BinaryTreeCreation binaryTreeCreation = new BinaryTreeCreation();
		BinaryTreeNode root = binaryTreeCreation.createBinaryTree(array);
		System.out.println(root.getData());
		BinaryTreeTraversal binaryTreeTraversal = new BinaryTreeTraversal();
		binaryTreeTraversal.traverseTree(root);
	}
}
