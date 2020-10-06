/**
 * 
 */
package com.amit.binaryTree;

/**
 * Node class for binary tree. Contains node and children.
 * @author amit
 */
public class BinaryTreeNode {

	private int data;
	private BinaryTreeNode left;
	private BinaryTreeNode right;
	/**
	 * @return the data
	 */
	public int getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(int data) {
		this.data = data;
	}
	/**
	 * @return the left
	 */
	public BinaryTreeNode getLeft() {
		return left;
	}
	/**
	 * @param left the left to set
	 */
	public void setLeft(BinaryTreeNode left) {
		this.left = left;
	}
	/**
	 * @return the right
	 */
	public BinaryTreeNode getRight() {
		return right;
	}
	/**
	 * @param right the right to set
	 */
	public void setRight(BinaryTreeNode right) {
		this.right = right;
	}
}
