package com.amit.doublyList;

public class BasicOperations {

	private Node head;
	private Node tail;
	
	public static void main(String[] args) {
		BasicOperations operations= new BasicOperations();
		int[] arr= {1,2,3,2,1};
		operations.buildDoublyList(arr);
		operations.forwardTraverse();
		operations.backwardTraverse();
		boolean isPalindrome= operations.isPalindrome();
		System.out.println("is palindrome: "+ isPalindrome);
	}
	
	/**
	 * Build doubly list from array
	 * @param arr
	 */
	private void buildDoublyList(int[] arr) {
		if (arr == null || arr.length == 0) {
			return;
		}
		Node currentNode = new Node(arr[0]);
		head= currentNode;
		for (int i = 1; i < arr.length; i++) {
			Node newNode = new Node(arr[i]);
			currentNode.setNext(newNode);
			newNode.setPrevious(currentNode);
			currentNode = newNode;
		}
		tail= currentNode;
	}
	
	/**
	 * Is list palindrome or not
	 * @return
	 */
	private boolean isPalindrome() {
		Node forwardPtr = head;
		Node backwardPtr = tail;
		while (!(forwardPtr == backwardPtr || backwardPtr == forwardPtr.getNext())) {
			if (forwardPtr.getData() != backwardPtr.getData()) {
				return false;
			}
			forwardPtr = forwardPtr.getNext();
			backwardPtr = backwardPtr.getPrevious();
		}
		return true;
	}

	
	/**
	 * Traverse list in forward direction
	 */
	private void forwardTraverse()
	{
		Node currentNode= head;
		while(currentNode!= null)
		{
			System.out.print(currentNode.getData()+"\t");
			currentNode= currentNode.getNext();
		}
		System.out.println();
	}
	
	/**
	 * Traverse list in forward direction
	 */
	private void backwardTraverse()
	{
		Node currentNode= tail;
		while(currentNode!= null)
		{
			System.out.print(currentNode.getData()+"\t");
			currentNode= currentNode.getPrevious();
		}
		System.out.println();
	}
}