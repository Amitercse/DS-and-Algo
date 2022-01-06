package com.amit.model;

public class Queue {

	private int front=-1;
	private int rear=-1;
	private int[] arr;
	
	public Queue(int size) {
		arr= new int[size];
	}
	
	public boolean isFull()
	{
		return (rear==arr.length-1);
	}
	
	public boolean isEmpty()
	{
		return (front==-1 || front> rear);
	}
	
	public void enqueue(int data) {
		if (isFull()) {
			System.out.println("queue is full");
			return;
		}
		if (rear == -1) {
			front = 0;
		}
		arr[++rear] = data;
	}
	
	public int dequeue() {
		if (isEmpty()) {
			System.out.println("queue is empty");
			return -1;
		} 
		int element = arr[front];
		front++;
		return element;
	}
}
