package com.amit.heap;

public class MaxHeap {

	private int[] arr;
	private int heapIndex=-1;
	
	public MaxHeap(int size) {
		arr= new int[size];
	}
	
	/**
	 * Get parent index of an index
	 * @param index
	 * @return
	 */
	private int getParentIndex(int index) {
		if (index == 0) {
			System.out.println("no parent for root index");
			return 0;
		} else {
			return (index - 1) / 2;
		}

	}
	
	/**
	 * Add element in heap
	 * @param element
	 */
	public void addElementInHeap(int element) {
		if (heapIndex >= arr.length - 1) {
			System.out.println("heap is full");
			return;
		}
		heapIndex++;
		arr[heapIndex] = element;
		heapifyUp(heapIndex);
	}
	
	/**
	 * Heapify from child to parent
	 * @param elementIndex
	 */
	private void heapifyUp(int elementIndex) {
		while (elementIndex > 0) {
			int parentIndex = getParentIndex(elementIndex);
			if (arr[parentIndex] < arr[elementIndex]) {
				arr[parentIndex] = arr[parentIndex] + arr[elementIndex];
				arr[elementIndex] = arr[parentIndex] - arr[elementIndex];
				arr[parentIndex] = arr[parentIndex] - arr[elementIndex];
			}
			elementIndex = parentIndex;
		}
	}
	
	/**
	 * Print max heap
	 */
	public void printHeap() {
		System.out.println("=============max heap===============");
		for (int i = 0; i <= heapIndex; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println();
	}
	
	/**
	 * Delete root from heap
	 */
	public void deleteElement() {
		if (heapIndex == -1) {
			System.out.println("heap is empty");
			return;
		}
		arr[0] = arr[heapIndex];
		heapIndex--;
		heapifyDown(0);
	}

	/**
	 * heapify from parent to child
	 * @param index
	 */
	public void heapifyDown(int index) {
		while (index <= (heapIndex - 1) / 2) {
			int largest = index;
			int left = 2 * index + 1;
			int right = 2 * index + 2;

			if (left <= heapIndex && arr[left] > arr[largest]) {
				largest = left;
			}
			if (right <= heapIndex && arr[right] > arr[largest]) {
				largest = right;
			}
			if (largest != index) {
				arr[largest] = arr[largest] + arr[index];
				arr[index] = arr[largest] - arr[index];
				arr[largest] = arr[largest] - arr[index];
				index = largest;
			} else {
				break;
			}
		}
	}
	
	public int findKthLargest(int k) {
		if (k > heapIndex) {
			System.out.println("k is greater than the size of heap");
			return -1;
		}
		// if third largest needs to be found then we will delete 2 times and then at
		// index 0 we can find third lasgest
		for (int i = 1; i < k; i++) {
			deleteElement();
		}
		return arr[0];
	}
}
