package com.amit.sort;

/**
 * Insertion sort algorithm.
 * @author amit
 *
 */
public class InsertionSort {

	/**
	 * Complexity is O(n^2) but in best case O(n). 
	 * Scan all previous element and check where element can be a best fit.
	 * @param arr
	 * @return
	 */
	public int[] sort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int j = i - 1;
			int key = arr[i];
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
		return arr;
	}
	
	public static void main(String[] args) {
		int[] arr = { 1, 4, 2, 6, 5, 7, 5 };
		InsertionSort insertionSort = new InsertionSort();
		arr = insertionSort.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+"\t");
		}
	}
}
