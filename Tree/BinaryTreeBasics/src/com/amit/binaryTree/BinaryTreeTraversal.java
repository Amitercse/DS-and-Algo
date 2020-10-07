package com.amit.binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
	
	/**
	 * Pre-order traversal over tree using recursion. Runtime complexity will be O(n).
	 * It doesn't need extra space to store data but for recursion it needs to store
	 * function calls in stack.
	 * @author amit
	 * @param root
	 */
	public void preOrderTraversalUsingRecursion(BinaryTreeNode root) {
		if (root != null) {
			System.out.print(root.getData() + "\t");
			preOrderTraversalUsingRecursion(root.getLeft());
			preOrderTraversalUsingRecursion(root.getRight());
		}
	}
	
	/**
	 * Pre order traversal using iteration. It needs O(n) runtime complexity
	 * to visit each node. Also it takes space O(n) for stack. 
	 * @author amit
	 * @param root
	 */
	public void preorderTraversalUsingIteration(BinaryTreeNode root) {
		if (root != null) {
			Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
			stack.push(root);
			while (!stack.isEmpty()) {
				BinaryTreeNode node = stack.pop();
				System.out.print(node.getData() + "\t");
				if (node.getRight() != null) {
					stack.push(node.getRight());
				}
				if (node.getLeft() != null) {
					stack.push(node.getLeft());
				}
			}
		}
	}
}
