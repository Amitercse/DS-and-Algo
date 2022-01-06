package com.amit.model;

public class DoublyLinkedList {

	public class Node {
		public int data;
		public Node next;
		public Node previous;
	}
	
	private Node head;
	private Node tail;
	private int size;
	
	public void insertAtHead(int data) {
		Node node = new Node();
		node.data = data;
		if (head == null) {
			head = node;
			tail = node;
		} else {
			node.next = head;
			head.previous = node;
			head = node;
		}
		size++;
	}
	
	public void insertAtEnd(int data) {
		Node node = new Node();
		node.data = data;
		if (tail == null) {
			head = node;
			tail = node;
		} else {
			tail.next = node;
			node.previous = tail;
			tail = node;
		}
		size++;
	}
	
	public Node getHead() {
		return head;
	}

	public Node getTail() {
		return tail;
	}
	
	public int getSize() {
		return size;
	}
}
