package com.amit.sort;

/**
 * Selection sort algorithm. Selection sort takes O(n^2) like bubble sort but
 * difference is that, bubble sort compare and swap while selection sort select
 * min value index and later swap it with another array element.
 * @author amit
 */
public class SelectionSort {

	/**
	 * For each array element, check all next elements to find which one is smallest
	 * and if element is not smallest then swap it with smallest one.
	 * @param arr
	 * @return
	 */
	public int[] sort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[i]) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				arr[i] = arr[i] + arr[minIndex];
				arr[minIndex] = arr[i] - arr[minIndex];
				arr[i] = arr[i] - arr[minIndex];
			}
		}
		return arr;
	}
	
	public static void main(String[] args) {
		int[] arr = { 1, 4, 6, 3, 8, 7, 6, 9 };
		SelectionSort selectionSort = new SelectionSort();
		arr = selectionSort.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
	}
}
