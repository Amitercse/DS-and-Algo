package com.amit.queue;

public class Queue {

	String[] arr;
	int front=-1;
	int rear=-1;
	
	/**
	 * @param size
	 */
	public Queue(int size) {
		arr= new String[size];
	}
	
	/**
	 * Check if queue is full
	 * @return
	 */
	public boolean isFull() {
		return (rear == arr.length - 1);
	}
	
	/**
	 * Check if queue is empty
	 * @return
	 */
	public boolean isEmpty() {
		return (front == -1 || front > rear);
	}
	
	/**
	 * Insert data in queue
	 * @param data
	 */
	public void enque(String data) {
		if (isFull()) {
			System.out.println("queue is full");
			return;
		}
		if (rear == -1) {
			front = 0;
		}
		rear++;
		arr[rear] = data;
	}
	
	/**
	 * Remove from queue
	 * @return
	 */
	public String deque() {
		if (isEmpty()) {
			System.out.println("queue is empty");
			return null;
		}
		String element = arr[front];
		front++;
		return element;
	}
}
