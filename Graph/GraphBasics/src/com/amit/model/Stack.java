package com.amit.model;

public class Stack {

	private int top = -1;
	private int arr[];

	public Stack(int size) {
		arr = new int[size];
	}

	public boolean isFull() {
		return (top == arr.length - 1);
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public void push(int data) {
		if (isFull()) {
			System.out.println("stack is full");
			return;
		}
		arr[++top] = data;
	}

	public int pop() {
		if (isEmpty()) {
			System.out.println("stack is empty");
			return -1;
		}
		int element = arr[top];
		top--;
		return element;
	}

	public int peek() {
		if (isEmpty()) {
			System.out.println("stack is empty");
			return -1;
		}
		return arr[top];
	}
}
