package com.amit.heap;

public class Main {

	public static void main(String[] args) throws Exception {
		MinHeap minHeap = new MinHeap();
		int[] elementsArr = { 10, 4, 9, 1, 7, 5, 3 };
		minHeap.initializeHeap(elementsArr.length);
		for (int i = 0; i < elementsArr.length; i++) {
			minHeap.insertElementInMinHeap(elementsArr[i]);
		}
		minHeap.printHeap();
		int[] arr = { 4, 7, 1, 10, 3, 2 };
		minHeap.heapifyEntireArray(arr);
		minHeap.deleteFromHeap();
		MaxHeap maxHeap = new MaxHeap(elementsArr.length);
		for (int i = 0; i < elementsArr.length; i++) {
			maxHeap.addElementInHeap(elementsArr[i]);
		}
		maxHeap.printHeap();
		maxHeap.deleteElement();
		maxHeap.printHeap();
		System.out.println("kth largest element: "+maxHeap.findKthLargest(3));
	}
}
