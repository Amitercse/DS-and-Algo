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
	 * Algorithm steps-
	 * * Create root of tree using first element of array.
	 * * Maintain a current node and initialize it with root.
	 * * Read element from array, create a node with data and push it to queue.
	 * * Make new node as a child(left or right) of current node. If current node
	 * * has both left and right children assigned then pop node from queue to
	 * * make it as current node and assign new node as child of this node. 
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
}
