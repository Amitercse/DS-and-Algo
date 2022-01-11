package com.amit.heap;

public class MinHeap {
	
	private int[] minHeap;
	private int heapIndex=0;
	
	/**
	 * Initialize min heap array with capacity
	 * @param size
	 */
	private void initializeHeap(int size)
	{
		minHeap= new int[size];
	}
	
	/**
	 * Get the parent index of current element
	 * @param elementIndex
	 * @return
	 * @throws Exception
	 */
	private int getParentIndex(int elementIndex) throws Exception
	{
		if(elementIndex>0)
		{
			return (elementIndex-1)/2;
		}
		else
		{
			throw new Exception("No parent for root element");
		}
	}
	
	private void insertElementInMinHeap(int element) throws Exception {
		minHeap[heapIndex++]= element;
		// Maintain min heap property
		heapifyUp(heapIndex-1);
	}
	
	/**
	 * Check the min heap property and adjust elements
	 * @param elementIndex
	 * @throws Exception
	 */
	private void heapifyUp(int elementIndex) throws Exception {
		int temp=minHeap[elementIndex];
		
		while(elementIndex>0 && temp<minHeap[getParentIndex(elementIndex)])
		{
			int parentIndex= getParentIndex(elementIndex);
			minHeap[elementIndex]= minHeap[parentIndex];
			elementIndex= parentIndex;
		}
		minHeap[elementIndex]= temp;
	}
	
	private void printHeap()
	{
		for(int i=0; i<minHeap.length; i++)
		{
			System.out.print(minHeap[i]+"\t");
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
			if (left < arr.length && arr[left] < arr[smallest]) {
				smallest = left;
			}
			if (right < arr.length && arr[right] < arr[smallest]) {
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

	private void heapifyEntireArray(int[] arr) {
		int i = (arr.length - 1) / 2;
		for (; i >= 0; i--) {
			heapify(arr, i, arr.length);
		}
		for (int element : arr) {
			System.out.print(element + "\t");
		}
	}
	
	public static void main(String[] args) throws Exception {
		MinHeap minHeap= new MinHeap();
		int[] elementsArr= {10,4,9,1,7,5,3};
		minHeap.initializeHeap(elementsArr.length);
		for(int i=0; i<elementsArr.length; i++)
		{
			minHeap.insertElementInMinHeap(elementsArr[i]);
		}
		minHeap.printHeap();
		int[] arr= {4,7,1,10,3,2};
		minHeap.heapifyEntireArray(arr);
	}
}