package com.amit.search;

import java.util.Arrays;

/**
 * @author amit
 * Binary search class.
 */
public class BinarySearch {

	/**
	 * Binary search algorithm to find element in array
	 * @param arr
	 * @param element
	 * @return boolean
	 */
	public boolean findElement(int[] arr, int element) {
		Arrays.sort(arr);
		int start = 0;
		int end = arr.length - 1;
		boolean elementFound = false;
		// Checking first and last index to check if element is present at start or end.
		if (element == arr[start]) {
			return true;
		} else if (element == arr[end]) {
			return true;
		}
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (element == arr[mid]) {
				elementFound = true;
				break;
			} else if (element > arr[mid]) {
				start = mid + 1;
			} else if (element < arr[mid]) {
				end = mid - 1;
			}
		}
		return elementFound;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 6, 5, 4, 8, 7 };
		BinarySearch binarySearch = new BinarySearch();
		boolean elementFound = binarySearch.findElement(arr, 7);
		if (elementFound) {
			System.out.println("Found element in array");
		} else {
			System.out.println("Element not found in array");
		}
	}
}
