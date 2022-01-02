package com.amit.list;

import java.util.HashSet;
import java.util.Set;

public class ListBasicOperations {

	private static Node head;
	
	public static void main(String[] args) {
		int arr[]= {1,2,3,4,5,1};
		ListBasicOperations operations= new ListBasicOperations();
		Node headNode= operations.buildLinkedList(arr);
		head= headNode;
		operations.insertAfter(6, 3);
		operations.deleteByData(2);
		operations.displayElements(head);
		boolean dataFound= operations.searchData(4);
		System.out.println("data found: "+ dataFound);
	//	operations.addLoop();
		boolean loopDetected= operations.detectLoop();
		System.out.println("Loop detected: "+ loopDetected);
		operations.findMid();
		operations.removeDuplicates();
		operations.displayElements(head);
		Node firstListHead= head;
		int newArr[]= {7,8,3,9,10,4};
		Node secondListHead= operations.buildLinkedList(newArr);
	//	operations.findUnion(firstListHead, secondListHead);
		operations.findIntersection(firstListHead, secondListHead);
		operations.reverseLinkedList();
		operations.displayElements(head);
	}
	
	/**
	 * Build a linked list from array
	 */
	private Node buildLinkedList(int[] arr) {
		Node headNode= null;
		for (int i : arr) {
			headNode= insertAtEnd(i, headNode);
		}
		return headNode;
	}
	
	/**
	 * Insert at the end of linked list
	 */
	private Node insertAtEnd(int data, Node headNode) {
		Node node = new Node(data);
		node.setNext(null);
		if (headNode == null) {
			headNode = node;
		} else {
			Node currentNode = headNode;
			while (currentNode.getNext() != null) {
				currentNode = currentNode.getNext();
			}
			currentNode.setNext(node);
		}
		return headNode;
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
	 * Find mid of a linked list
	 */
	private void findMid() {
		if (head == null) {
			System.out.println("list is empty");
			return;
		}
		if (head.getNext() == null) {
			System.out.println("list has only one element");
			return;
		}
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}
		System.out.println("Mid data: " + slow.getData());
	}

	/**
	 * Remove duplicates from linked list
	 */
	private void removeDuplicates() {
		if (head == null) {
			return;
		}
		Set<Integer> set = new HashSet<Integer>();
		set.add(head.getData());
		Node previousNode = head;
		Node currentNode = head.getNext();
		while (currentNode != null) {
			if (set.contains(currentNode.getData())) {
				previousNode.setNext(currentNode.getNext());
				currentNode = currentNode.getNext();
			} else {
				previousNode = currentNode;
				currentNode = currentNode.getNext();
			}
		}
	}
	
	private void findUnion(Node firstListHead, Node secondListHead) {
		if (firstListHead == null && secondListHead == null) {
			return;
		}
		Node unionHead= null;
		Node currentNode = firstListHead;
		Node unionNode = null;
		Node unionPreviousNode = null;
		Set<Integer> set = new HashSet<>();
		while (currentNode != null) {
			if (unionNode == null) {
				unionNode = currentNode;
				currentNode = currentNode.getNext();
				set.add(unionNode.getData());
			} else if (!set.contains(currentNode.getData())) {
				unionPreviousNode = unionNode;
				unionNode = currentNode;
				unionPreviousNode.setNext(unionNode);
				currentNode = currentNode.getNext();
				set.add(unionNode.getData());
			} else {
				currentNode = currentNode.getNext();
			}
		}
		currentNode = secondListHead;
		while (currentNode != null) {
			if (unionNode == null) {
				unionNode = currentNode;
				currentNode = currentNode.getNext();
				set.add(unionNode.getData());
			} else if (!set.contains(currentNode.getData())) {
				unionPreviousNode = unionNode;
				unionNode = currentNode;
				unionPreviousNode.setNext(unionNode);
				currentNode = currentNode.getNext();
				set.add(unionNode.getData());
			} else {
				currentNode = currentNode.getNext();
			}
		}
		unionHead= firstListHead;
		if(firstListHead== null)
		{
			unionHead= secondListHead;
		}
		displayElements(unionHead);
	}
	
	private void findIntersection(Node firstListHead, Node secondListHead) {
		if (firstListHead == null && secondListHead == null) {
			return;
		}
		Node unionHead = null;
		Node currentNode = firstListHead;
		Node unionNode = null;
		Node unionPreviousNode = null;
		Set<Integer> set = new HashSet<>();
		while (currentNode != null) {
			set.add(currentNode.getData());
			currentNode = currentNode.getNext();
		}
		currentNode = secondListHead;
		while (currentNode != null) {
			if (set.contains(currentNode.getData())) {
				if (unionNode == null) {
					unionNode = new Node(currentNode.getData());
					unionHead= unionNode;
					currentNode = currentNode.getNext();
					set.add(unionNode.getData());
				} else {
					unionPreviousNode = unionNode;
					unionNode = new Node(currentNode.getData());
					unionPreviousNode.setNext(unionNode);
					currentNode = currentNode.getNext();
					set.add(unionNode.getData());
				}
			} else {
				set.add(currentNode.getData());
				currentNode = currentNode.getNext();
			}
		}
		displayElements(unionHead);
	}



	/**
	 * Display elements of a linked list
	 */
	private void displayElements(Node head) {
		Node currentNode = head;
		while (currentNode != null) {
			System.out.print(currentNode.getData() + "\t");
			currentNode = currentNode.getNext();
		}
		System.out.println();
	}
}
