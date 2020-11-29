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
	}
}