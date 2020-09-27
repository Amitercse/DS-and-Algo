package com.amit.search;

/**
 * @author amit
 * Find element in array using linear search
 */
public class LinearSearch {

	/**
	 * @author amit
	 * @param arr
	 * @param element
	 * @return boolean
	 */
	public boolean searchElement(int[] arr, int element) {
		boolean elementFound = false;
		for (int i = 0; i < arr.length; i++) {
			if (element == arr[i]) {
				elementFound = true;
				break;
			}
		}
		return elementFound;
	}
	
	public static void main(String[] args) {
		int[] arr = { 1, 2, 4, 8, 5, 9, 7 };
		LinearSearch linearSearch = new LinearSearch();
		boolean foundElement = linearSearch.searchElement(arr, 11);
		if (foundElement) {
			System.out.println("Element found in the array");
		} else {
			System.out.println("No element found");
		}
	}
}
