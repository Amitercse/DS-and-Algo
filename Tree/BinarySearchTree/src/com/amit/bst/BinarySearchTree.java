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
	 * Search an item in binary search tree.
	 * @author amit
	 * @param data
	 * @return
	 */
	public boolean searchItem(int data) {
		boolean isFound = false;
		BinaryTreeNode currentNode = root;
		// If root is null then also it will be handled using below condition.
		while (currentNode != null) {
			if (currentNode.getData() == data) {
				isFound = true;
				break;
			} else if (data < currentNode.getData()) {
				currentNode = currentNode.getLeft();
			} else {
				currentNode = currentNode.getRight();
			}
		}
		return isFound;
	}
	
	/**
	 * Delete the node from binary search tree. Here while deleting we are trying to
	 * maintain the property of BST.
	 * @author amit
	 * @param data
	 */
	public void deleteNode(int data) {
		if (root == null) {
			System.out.println("Tree is emplty");
		} else {
			BinaryTreeNode parent = null;
			BinaryTreeNode currentNode = root;
			// Find the node which needs to be deleted.
			while (currentNode != null && currentNode.getData() != data) {
				parent = currentNode;
				if (data < currentNode.getData()) {
					currentNode = currentNode.getLeft();
				} else {
					currentNode = currentNode.getRight();
				}
			}
			if (currentNode == null) {
				System.out.println("node not found");
			} else if (parent == null && currentNode.getLeft() == null && currentNode.getRight() == null) {
				root = null;
				System.out.println("deleted root");
			}
			// If node needs to be deleted is leaf node.
			else if (currentNode.getLeft() == null && currentNode.getRight() == null) {
				if (parent.getLeft() == currentNode) {
					parent.setLeft(null);
				} else {
					parent.setRight(null);
				}
			}
			/*
			 * Node needs to be deleted is having one child only, either left child or right
			 * child. Here checking for || condition because if both the children are null
			 * then previous if block would have caught it and control will never come here.
			 */
			else if (currentNode.getLeft() == null || currentNode.getRight() == null) {
				BinaryTreeNode node = currentNode.getLeft() != null ? currentNode.getLeft() : currentNode.getRight();
				if (parent.getLeft() == currentNode) {
					parent.setLeft(node);
				} else {
					parent.setRight(node);
				}
			}
			// Node needs to be deleted has both left and right child.
			else {
				BinaryTreeNode node = currentNode.getRight();
				if (parent.getLeft() == currentNode) {
					parent.setLeft(node);
				} else {
					parent.setRight(node);
				}
				if (node.getLeft() != null) {
					node.getLeft().setLeft(currentNode.getLeft());
				} else {
					node.setLeft(currentNode.getLeft());
				}
			}
		}
	}
	
	/**
	 * Level order traversal for binary search tree.
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
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(8);
		bst.insert(4);
		bst.insert(12);
		bst.insert(10);
		bst.insert(14);
		bst.insert(11);
		bst.insert(9);
		bst.insert(15);
		bst.insert(13);
		bst.insert(5);
		bst.insert(3);
		bst.traverseTree(bst.root);
		boolean isFound = bst.searchItem(4);
		System.out.println("\nelement found: " + isFound);
		bst.deleteNode(12);
		bst.traverseTree(bst.root);
	}
}
