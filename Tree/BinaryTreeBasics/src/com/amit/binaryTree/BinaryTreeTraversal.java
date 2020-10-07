package com.amit.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author amit
 * Class for binary tree traversal. Using this class tree elements will 
 * be traversed at least once.
 */
public class BinaryTreeTraversal {

	/**
	 * It is simple traversal of tree like traversal for BFS. It needs O(n) time
	 * complexity as we are looking for each element and O(n) space complexity for queue.
	 * @param root
	 */
	public void traverseTree(BinaryTreeNode root) {
		if (root == null) {
			System.out.println("Tree is empty");
		} else {
			System.out.print(root.getData() + "\t");
			Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
			if (root.getLeft() != null) {
				queue.offer(root.getLeft());
			}
			if (root.getRight() != null) {
				queue.offer(root.getRight());
			}
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
	
	/**
	 * Pre-order traversal over tree using recursion. Runtime complexity will be O(n).
	 * It doesn't need extra space to store data but for recursion it needs to store
	 * function calls in stack.
	 * @author amit
	 * @param root
	 */
	public void preOrderTraversalUsingRecursion(BinaryTreeNode root) {
		if (root != null) {
			System.out.println(root.getData());
			preOrderTraversalUsingRecursion(root.getLeft());
			preOrderTraversalUsingRecursion(root.getRight());
		}
	}
}
