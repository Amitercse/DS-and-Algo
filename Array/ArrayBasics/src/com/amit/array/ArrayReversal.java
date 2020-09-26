package com.amit.array;

/**
 * @author amit
 * This class for array reversal programs. Using two methods-
 * 	* Looping over array.
 * 	* Recursion.
 */
public class ArrayReversal {

	/**
	 * Reverser an array after looping through all elements.
	 * Swap start and end elements, and increment start index
	 * and decrement end index.
	 * @author amit
	 * @param arr
	 */
	public void reverseArray(int[] arr) {
		int last = arr.length - 1;
		for (int i = 0; i < last; i++, last--) {
			arr[i] = arr[i] + arr[last];
			arr[last] = arr[i] - arr[last];
			arr[i] = arr[i] - arr[last];
		}
	}
	
	/**
	 * Reverse array using recursion. Swap start and end index 
	 * elements. Increase start index and decrease end index and
	 * again call method to reverse array recursively.
	 * @author amit
	 * @param arr
	 * @param start
	 * @param end
	 */
	public void reverseArrUsingRecursion(int[] arr, int start, int end) {
		if (start >= end)
			return;
		arr[start] = arr[start] + arr[end];
		arr[end] = arr[start] - arr[end];
		arr[start] = arr[start] - arr[end];
		reverseArrUsingRecursion(arr, start + 1, end - 1);
	}
	
	/**
	 * Print array elements.
	 * @author amit
	 * @param arr
	 */
	public void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
	}
	
	/**
	 * Main method for the class.
	 * @author amit
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		ArrayReversal arrayReversal = new ArrayReversal();
		arrayReversal.reverseArray(arr);
		arrayReversal.printArray(arr);
		arrayReversal.reverseArrUsingRecursion(arr, 0, arr.length - 1);
		arrayReversal.printArray(arr);
	}
}
