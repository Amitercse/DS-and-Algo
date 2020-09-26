package com.amit.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author amit
 * Program to find duplicate number in the array.
 * Assuming that there is only one duplicate in the array.
 */
public class DuplicateNumFinder {
	
	/**
	 * Brute force approach to find duplicate number in array.
	 * @author amit
	 * @param arr
	 */
	public void findDuplicateNum(int[] arr) {
		boolean foundDuplicate = false;
		int duplicateNum = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					duplicateNum = arr[i];
					foundDuplicate = true;
					break;
				}
			}
		}
		if (foundDuplicate) {
			System.out.println("found duplicate number using brute force: " + duplicateNum);
		} else {
			System.out.println("No duplicate found");
		}
	}

	/**
	 * Found duplicate num in array after sorting elements.
	 * It can be found in one iteration but needs extra complexity
	 * to sort the array. 
	 * @author amit
	 * @param arr
	 */
	public void findDuplicateNumUsingSort(int[] arr) {
		boolean duplicateFound = false;
		int duplicateNum = 0;
		Arrays.sort(arr);
		int previous = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == previous) {
				duplicateFound = true;
				duplicateNum = arr[i];
				break;
			}
			previous = arr[i];
		}
		if (duplicateFound) {
			System.out.println("Duplicate found using sort: " + duplicateNum);
		} else {
			System.out.println("No duplicate found");
		}
	}
	
	/**
	 * Find duplicate element using set. It needs O(n) complexity but 
	 * also needs extra space of hashSet.
	 * @author amit
	 * @param arr
	 */
	public void findDuplicateUsingSet(int[] arr) {
		int duplicateNum = 0;
		boolean foundDuplicate = false;
		Set<Integer> set = new HashSet<Integer>();
		set.add(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			if (set.contains(arr[i])) {
				foundDuplicate = true;
				duplicateNum = arr[i];
				break;
			}
			set.add(arr[i]);
		}
		if (foundDuplicate) {
			System.out.println("found duplicate using set: " + duplicateNum);
		} else {
			System.out.println("no duplicate found");
		}
	}
	
	void printRepeating(int arr[], int size) 
    { 
        int i;   
        System.out.println("The repeating elements are : "); 
     
        for (i = 0; i < size; i++) 
        { 
            if (arr[ Math.abs(arr[i])] >= 0) 
                arr[ Math.abs(arr[i])] = -arr[ Math.abs(arr[i])]; 
            else
                System.out.print(Math.abs(arr[i]) + " "); 
        }          
    } 
	
	public static void main(String[] args) {
		int arr[] = { 1, 2, 2, 5, 4, 7, 2 };
		DuplicateNumFinder duplicateFinder = new DuplicateNumFinder();
		duplicateFinder.findDuplicateNum(arr);
		duplicateFinder.findDuplicateNumUsingSort(arr);
		duplicateFinder.findDuplicateUsingSet(arr);
		duplicateFinder.printRepeating(arr, arr.length);
	}
}
