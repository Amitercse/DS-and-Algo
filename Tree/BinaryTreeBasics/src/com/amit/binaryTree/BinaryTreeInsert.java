package com.amit.binaryTree;

/**
 * @author amit
 * Class to perform operation to insert a node in binary tree
 */
public class BinaryTreeInsert {

	/**
	 * Method to insert node in binary tree using recursion.
	 * It is simple insertion where we will insert wherever place
	 * is empty. Traversal using recursion is similar to level
	 * order traversal.
	 * Here returning boolean value after insertion to either insert
	 * in left or right. Because one node can be inserted at one place
	 * only. If we don't return true and put boolean condition then
	 * method will insert node at both left and right place.
	 * @param root
	 * @param node
	 * @return
	 * @throws Exception
	 */
	public boolean insertUsingRecursion(BinaryTreeNode root, BinaryTreeNode node) throws Exception {
		if (node == null) {
			throw new Exception("Trying to insert null node in tree");
		}
		if (root == null) {
			root = node;
			return true;
		} else if (root.getLeft() == null) {
			root.setLeft(node);
			return true;
		} else if (root.getRight() == null) {
			root.setRight(node);
			return true;
		}
		return insertUsingRecursion(root.getLeft(), node) || insertUsingRecursion(root.getRight(), node);
	}
	
	public static void main(String[] args) throws Exception {
		int[] array = { 1, 2, 3, 4, 5, 6, 7 };
		BinaryTreeCreation binaryTreeCreation = new BinaryTreeCreation();
		// Create binary tree using array
		BinaryTreeNode root = binaryTreeCreation.createBinaryTree(array);
		BinaryTreeInsert binaryTreeInsert = new BinaryTreeInsert();
		BinaryTreeNode node = new BinaryTreeNode();
		node.setData(8);
		// Insert node in binary tree
		binaryTreeInsert.insertUsingRecursion(root, node);
		BinaryTreeTraversal traversal = new BinaryTreeTraversal();
		// Level order traversal
		traversal.levelOrderTraversal(root);
	}
}
