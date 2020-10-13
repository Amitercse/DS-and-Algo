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
	 * It is simple traversal of tree where each level will be traversed first. 
	 * It needs O(n) time complexity as we are looking for each element and O(n) 
	 * space complexity for queue.
	 * Algorithms steps-
	 * * Insert root in queue and repeat below steps until queue is empty
	 * * Remove element from queue, print its data and insert its left
	 * * right children and queue.
	 * @param root
	 */
	public void levelOrderTraversal(BinaryTreeNode root) {
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
	 * Algorithm steps-
	 * * Push root in the stack.
	 * * Pop node from stack and read its data. Also keep pushing
	 * * in stack its right and left children in reverse order. 
	 * * First right child then left child. 
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
	
	/**
	 * Inorder traversal using recursion. It will take O(n) runtime complexity 
	 * to visit each node. No extra space needed to store data but internally
	 * recursion needs stack to maintain function call.
	 * @author amit
	 * @param root
	 */
	public void inorderTraversalUsingRecursion(BinaryTreeNode root) {
		if (root != null) {
			inorderTraversalUsingRecursion(root.getLeft());
			System.out.print(root.getData() + "\t");
			inorderTraversalUsingRecursion(root.getRight());
		}
	}
	
	/**
	 * Inorder traversal using iteration. Needs O(n) complexity to visit each
	 * node. Also needs O(n) extra space for stack.
	 * Algorithm steps-
	 * * From root keep pushing each left node in the stack until get null.
	 * * If found null then pop element from stack and read its data.
	 * * Also make right node of poppped node as current node to perform
	 * * same step.
	 * @author amit
	 * @param root
	 */
	public void inorderTraversalUsingIteration(BinaryTreeNode root) {
		if (root != null) {
			Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
			stack.push(root);
			BinaryTreeNode currentNode = root.getLeft();
			/* Only checking if stack is empty will not work here. Because
			 * after visiting all left nodes we trace back to root, stack
			 * will become empty but still right nodes of stacks are pending
			 * to visit. So check if stack is empty as well as current Node 
			 * is null.
			 */
			while (!(stack.isEmpty() && currentNode == null)) {
				if (currentNode != null) {
					stack.push(currentNode);
					currentNode = currentNode.getLeft();
				} else {
					currentNode = stack.pop();
					System.out.print(currentNode.getData() + "\t");
					currentNode = currentNode.getRight();
				}
			}
		}
	}
	
	/**
	 * Post order traversal using recursion. It will take O(n) runtime complexity 
	 * to visit each node. No extra space needed to store data but internally
	 * recursion needs stack to maintain function call.
	 * @author amit
	 * @param root
	 */
	public void postOrderTraversalUsingRecursion(BinaryTreeNode root) {
		if (root != null) {
			postOrderTraversalUsingRecursion(root.getLeft());
			postOrderTraversalUsingRecursion(root.getRight());
			System.out.print(root.getData()+"\t");
		}
	}
	
	/**
	 * It will take O(n) as time complexity and O(n) space for stack.
	 * Algorithm steps-
	 * * For each node visit left subtree and keep pushing in stack.
	 * * After pushing left subtree in stack push right subtree.
	 * * Since here we are visiting each node twice so keeping previous 
	 * * node also to check if visiting from left or right subtree.
	 * @author amit
	 * @param root
	 */
	public void postOrderTraversalUsingIteration(BinaryTreeNode root) {
		if (root != null) {
			Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
			stack.push(root);
			BinaryTreeNode previous = null;
			while (!stack.isEmpty()) {
				BinaryTreeNode curr = stack.peek();
				if (previous == null || curr == previous.getLeft() || curr == previous.getRight()) {
					if (curr.getLeft() != null) {
						stack.push(curr.getLeft());
					} else if (curr.getRight() != null) {
						stack.push(curr.getRight());
					}
				} else if (curr.getLeft() == previous && curr.getRight() != null) {
					stack.push(curr.getRight());
				} else {
					System.out.print(curr.getData() + "\t");
					stack.pop();
				}
				previous = curr;
			}
		}
	}
}
