package com.amit.heap;

public class MinHeap {
	
	private int[] minHeap;
	private int heapIndex=-1;
	
	/**
	 * Initialize min heap array with capacity
	 * @param size
	 */
	void initializeHeap(int size) {
		minHeap = new int[size];
	}
	
	/**
	 * Get the parent index of current element
	 * @param elementIndex
	 * @return
	 * @throws Exception
	 */
	private int getParentIndex(int elementIndex) throws Exception {
		if (elementIndex > 0) {
			return (elementIndex - 1) / 2;
		} else {
			throw new Exception("No parent for root element");
		}
	}
	
	void insertElementInMinHeap(int element) throws Exception {
		if(heapIndex==minHeap.length-1)
		{
			System.out.println("heap is full");
			return;
		}
		heapIndex++;
		minHeap[heapIndex] = element;
		// Maintain min heap property
		heapifyUp(heapIndex);
	}
	
	/**
	 * Check the min heap property and adjust elements
	 * @param elementIndex
	 * @throws Exception
	 */
	private void heapifyUp(int elementIndex) throws Exception {
		int temp = minHeap[elementIndex];

		while (elementIndex > 0 && temp < minHeap[getParentIndex(elementIndex)]) {
			int parentIndex = getParentIndex(elementIndex);
			minHeap[elementIndex] = minHeap[parentIndex];
			elementIndex = parentIndex;
		}
		minHeap[elementIndex] = temp;
	}
	
	/**
	 * Heapify down the root
	 */
	private void heapifyDown(int elementIndex, int heapSize) {
		while (elementIndex <= (heapSize - 1) / 2) {
			int smallest = elementIndex;
			int left = 2 * elementIndex + 1;
			int right = 2 * elementIndex + 2;
			if (left <= heapSize && minHeap[left] < minHeap[smallest]) {
				smallest = left;
			}
			if (right <= heapSize && minHeap[right] < minHeap[smallest]) {
				smallest = right;
			}
			if (smallest != elementIndex) {
				minHeap[smallest] = minHeap[smallest] + minHeap[elementIndex];
				minHeap[elementIndex] = minHeap[smallest] - minHeap[elementIndex];
				minHeap[smallest] = minHeap[smallest] - minHeap[elementIndex];
				elementIndex = smallest;
			} else {
				break;
			}
		}
	}
	
	void printHeap() {
		System.out.println("=============min heap===============");
		for (int i = 0; i <= heapIndex; i++) {
			System.out.print(minHeap[i] + "\t");
		}
		System.out.println();
	}
	
	/**
	 * Heapify entire heap at once
	 * @param arr
	 * @return
	 */
	private void heapify(int[] arr, int i, int size) {
		while (i <= size / 2) {
			int smallest = i;
			int left = 2 * i + 1;
			int right = 2 * i + 2;
			if (left < size && arr[left] < arr[smallest]) {
				smallest = left;
			}
			if (right < size && arr[right] < arr[smallest]) {
				smallest = right;
			}
			if (smallest != i) {
				arr[smallest] = arr[i] + arr[smallest];
				arr[i] = arr[smallest] - arr[i];
				arr[smallest] = arr[smallest] - arr[i];
				i = smallest;
			} else
				break;
		}
	}

	void heapifyEntireArray(int[] arr) {
		int i = (arr.length - 1) / 2;
		for (; i >= 0; i--) {
			heapify(arr, i, arr.length);
		}
		for (int element : arr) {
			System.out.print(element + "\t");
		}
		System.out.println();
	}
	
	void deleteFromHeap() {
		minHeap[0] = minHeap[heapIndex];
		heapIndex--;
		heapifyDown(0, heapIndex);
		printHeap();
	}
}