package com.amit.array;

/**
 * @author amit
 * Find second largest element in array
 */
public class SecondLargestElementFinder {

	/**
	 * Find second largest element in array
	 * @param arr
	 * @return
	 */
	public int secondLargestElementFinder(int[] arr) {
		int largestElement = arr[0];
		int secondLargest = arr[1];
		if (secondLargest > largestElement) {
			largestElement = largestElement + secondLargest;
			secondLargest = largestElement - secondLargest;
			largestElement = largestElement - secondLargest;
		}
		for (int i = 2; i < arr.length; i++) {
			if (arr[i] > largestElement) {
				secondLargest = largestElement;
				largestElement = arr[i];
			} else if (arr[i] > secondLargest) {
				secondLargest = arr[i];
			}
		}
		return secondLargest;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 8, 5, 6, 7, 4, 5, 8, 7, 9 };
		SecondLargestElementFinder finder = new SecondLargestElementFinder();
		int secondLargest = finder.secondLargestElementFinder(arr);
		System.out.println("second largest element: " + secondLargest);
	}
}
