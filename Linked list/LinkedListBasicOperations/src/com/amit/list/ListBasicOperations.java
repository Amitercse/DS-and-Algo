package com.amit.list;

public class ListBasicOperations {

	private Node head;
	
	public static void main(String[] args) {
		int arr[]= {1,2,3,4,5};
		ListBasicOperations operations= new ListBasicOperations();
		operations.buildLinkedList(arr);
		operations.insertAfter(6, 3);
		operations.deleteByData(2);
		operations.displayElements();
		boolean dataFound= operations.searchData(4);
		System.out.println("data found: "+ dataFound);
	//	operations.addLoop();
		boolean loopDetected= operations.detectLoop();
		System.out.println("Loop detected: "+ loopDetected);
		operations.reverseLinkedList();
		operations.displayElements();
	}
	
	/**
	 * Build a linked list from array
	 */
	private void buildLinkedList(int[] arr) {
		for (int i : arr) {
			insertAtEnd(i);
		}
	}
	
	/**
	 * Insert at the end of linked list
	 */
	private void insertAtEnd(int data) {
		Node node = new Node(data);
		node.setNext(null);
		if (head == null) {
			head = node;
		} else {
			Node currentNode = head;
			while (currentNode.getNext() != null) {
				currentNode = currentNode.getNext();
			}
			currentNode.setNext(node);
		}
	}
	
	/**
	 * Insert after a node having specific data
	 * @param data
	 * @param previousNodeData
	 */
	private void insertAfter(int data, int previousNodeData) {
		Node currentNode = head;
		boolean nodeFound = false;
		while (currentNode != null) {
			if (currentNode.getData() == previousNodeData) {
				nodeFound = true;
				break;
			}
			currentNode = currentNode.getNext();
		}
		if (nodeFound) {
			Node newNode = new Node(data);
			newNode.setNext(currentNode.getNext());
			currentNode.setNext(newNode);
		} else {
			System.out.println("Previous node data not found");
		}
	}
	
	/**
	 * Search data from linked list
	 * @param data
	 * @return
	 */
	private boolean searchData(int data) {
		Node currentNode = head;
		while (currentNode != null) {
			if (currentNode.getData() == data) {
				return true;
			}
			currentNode = currentNode.getNext();
		}
		return false;
	}
	
	/**
	 * Delete from head of linked list
	 */
	private void deleteAtHead() {
		if (head != null) {
			head = head.getNext();
		}
	}

	/**
	 * Delete a node having specific data
	 * @param data
	 */
	private void deleteByData(int data) {
		boolean nodeFound = false;
		if (head == null) {
			System.out.println("list is empty");
			return;
		}
		if (head.getData() == data) {
			deleteAtHead();
		} else {
			Node currentNode = head.getNext();
			Node previousNode = head;
			while (currentNode != null) {
				if (currentNode.getData() == data) {
					nodeFound = true;
					break;
				}
				previousNode = currentNode;
				currentNode = currentNode.getNext();
			}
			if (nodeFound) {
				previousNode.setNext(currentNode.getNext());
			} else {
				System.out.println("Node to be deleted not found");
			}
		}
	}
	
	/**
	 * Reverse a linked list
	 */
	private void reverseLinkedList() {
		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		if (head.getNext() == null) {
			return;
		}
		Node previousNode = head;
		Node currentNode = head.getNext();
		previousNode.setNext(null);
		while (currentNode != null && currentNode.getNext() != null) {
			Node next = currentNode.getNext();
			currentNode.setNext(previousNode);
			previousNode= currentNode;
			currentNode = next;
		}
		currentNode.setNext(previousNode);
		head = currentNode;
	}

	/**
	 * Detect loop in linked list
	 * @return
	 */
	private boolean detectLoop() {
		if (head == null) {
			System.out.println("List is empty");
		}
		if (head.getNext() == null) {
			return false;
		}
		Node slowPointer = head;
		Node fastPointer = head;
		while (fastPointer != null && fastPointer.getNext() != null) {
			slowPointer = slowPointer.getNext();
			fastPointer = fastPointer.getNext().getNext();
			if (slowPointer == fastPointer) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Add a loop to the linked list
	 */
	private void addLoop()
	{
		Node currentNode= head;
		while(currentNode!= null && currentNode.getNext()!= null)
		{
			currentNode= currentNode.getNext();
		}
		currentNode.setNext(head);
	}

	/**
	 * Display elements of a linked list
	 */
	private void displayElements() {
		Node currentNode = head;
		while (currentNode != null) {
			System.out.print(currentNode.getData() + "\t");
			currentNode = currentNode.getNext();
		}
		System.out.println();
	}
}
