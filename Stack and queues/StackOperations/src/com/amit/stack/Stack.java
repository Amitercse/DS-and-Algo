package com.amit.stack;

public class Stack {

	private int[] arr;
	private int top=-1;

	/**
	 * @param arr
	 */
	public Stack(int size) {
		arr= new int[size];
	}
	
	/**
	 * Push data in stack
	 * @param data
	 */
	public void push(int data) {
		if (isFull()) {
			System.out.println("stack is full");
			return;
		}
		top++;
		arr[top] = data;
	}
	
	/**
	 * Pop element from stack
	 * @return
	 */
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
	
	/**
	 * Check if stack is full
	 * @return
	 */
	public boolean isFull() {
		return (top == arr.length - 1);
	}
	
	public boolean isEmpty()
	{
		return (top==-1);
	}
	
	/**
	 * Return length of underlying array of stack.
	 * @return
	 */
	public int size() {
		return arr.length;
	}
}
