package com.amit.bst;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Class to perform basic operations on binary search tree like insert, lookup
 * and delete. Here not considering balancing binary search tree during
 * operations. Insert, lookup, delete takes O(log n) time complexity if it 
 * is balanced tree, else it may even take O(n) also.
 * @author amit
 */
public class BinarySearchTree {

	BinaryTreeNode root;
	
	/**
	 * Insert data in binary search tree. Here not thinking about balancing the
	 * tree.
	 * @author amit
	 * @param data
	 */
	public void insert(int data) {
		BinaryTreeNode node = new BinaryTreeNode();
		node.setData(data);
		// Here checking root separately because method doesn't have root as input
		// parameter. So for null tree, we need to set root for next insertion.
		if (root == null) {
			root = node;
			return;
		}
		BinaryTreeNode parent = null;
		BinaryTreeNode currentNode = root;
		while (currentNode != null) {
			parent = currentNode;
			if (data < currentNode.getData()) {
				currentNode = currentNode.getLeft();
			} else {
				currentNode = currentNode.getRight();
			}
		}
		if (data < parent.getData()) {
			parent.setLeft(node);
		} else {
			parent.setRight(node);
		}
	}
	
	/**
	 * 
	 * @author amit
	 * @param root
	 */
	public void traverseTree(BinaryTreeNode root) {
		if (root == null) {
			System.out.println("Tree is empty");
		} else {
			Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
			queue.offer(root);
			BinaryTreeNode currentNode;
			while (!queue.isEmpty()) {
				currentNode = queue.poll();
				System.out.print(currentNode.getData() + "\t");
				if (currentNode.getLeft() != null) {
					queue.offer(currentNode.getLeft());
				}
				if (currentNode.getRight() != null) {
					queue.offer(currentNode.getRight());
				}
			}
		}
	}
	
	public static void main(String[] args) {
		BinarySearchTree bst= new BinarySearchTree();
		bst.insert(4);
		bst.insert(7);
		bst.insert(6);
		bst.insert(3);
		bst.insert(1);
		bst.insert(4);
		bst.traverseTree(bst.root);
	}
}
