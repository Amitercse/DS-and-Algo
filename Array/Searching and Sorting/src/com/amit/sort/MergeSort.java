package com.amit.sort;

/**
 * Merge sort algorithm. Complexity - O(nlogn)
 * @author amit
 */
public class MergeSort {

	/**
	 * Merge sort algorithm on an array. Recursive approach for divide and conquer.
	 * @param arr
	 * @param start
	 * @param end
	 */
	public void sort(int[] arr, int start, int end) {
		if (start < end) {
			int mid = start + (end - start) / 2;
			sort(arr, start, mid);
			sort(arr, mid + 1, end);
			merge(arr, start, mid, end);
		}
	}

	/**
	 * Merge two sorted sub arrays. Here during merge we need to keep track the mid index of 
	 * array also, because we need to know the point to merge the arrays.
	 * @param arr
	 * @param start
	 * @param mid
	 * @param end
	 */
	public void merge(int[] arr, int start, int mid, int end) {
		int[] temp = new int[end - start + 1];
		int k = 0, i = start, j = mid + 1;
		/*
		 * Merge sorted arrays and make sure during merge also result array is sorted.
		 */
		while (i <= mid && j <= end) {
			if (arr[i] <= arr[j]) {
				temp[k] = arr[i];
				k++;
				i++;
			} else {
				temp[k] = arr[j];
				k++;
				j++;
			}
		}
		/*
		 * Copy remaining element of subarray to temp array. While merging it may be 
		 * possibility that one array is copied fully and another is not merged completely.
		 * So put rest of the elements also in temp array.
		 */
		while (i <= mid) {
			temp[k] = arr[i];
			k++;
			i++;
		}
		while (j <= end) {
			temp[k] = arr[j];
			j++;
			k++;
		}
		/*
		 * copy merged temp array to the final array. Final array needs to be modified from 
		 * start to end index but temp array will start to 0 so (i-start) is correct index 
		 * for temp array.
		 */
		for (int index = start; index <= end; index++) {
			arr[index] = temp[index - start];
		}
	}
	
	public static void main(String[] args) {
		int[] arr = { 1, 4, 2, 8, 6, 5, 7, 5 };
		MergeSort mergeSort = new MergeSort();
		mergeSort.sort(arr, 0, arr.length - 1);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
	}
}
