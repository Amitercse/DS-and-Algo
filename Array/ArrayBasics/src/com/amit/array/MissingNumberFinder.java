package com.amit.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author amit
 * Class to find missing element in array. We are trying three ways here.
 * 1.) Sort the array and the find if number is missing.
 * 2.) Find missing number using formula of sum of numbers from 1 to n.
 * 3.) Using hash set
 */
public class MissingNumberFinder {
	
	/**
	 * Since only one number of missing between one to n so,
	 * first find sum of elements in array. Then find expected 
	 * sum using formula- n*(n+1)/2. 
	 * Missing number= expected sum - array sum
	 * @author amit
	 * @param arr
	 * @return int
	 */
	public int findMissingElement(int[] arr) {
		int sum = 0;
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			sum = sum + arr[i];
		}
		int expectedSum = n * (n + 1) / 2;
		int missingNumber = expectedSum - sum;
		return missingNumber;
	}
	
	/**
	 * Scan the array and store elements in a set. Now since we are finding missing
	 * element from 1 to n, so check if each element exists in set or not.
	 * It needs extra space to store data in set and need two time iteration of n.
	 * @author amit
	 * @param arr
	 * @return int
	 */
	public int findMissingNumUsingSet(int[] arr) {
		Set<Integer> set = new HashSet<Integer>();
		int missingNum = 0;
		for (int i = 0; i < arr.length; i++) {
			set.add(arr[i]);
		}
		// now check if each element is present in set or not
		for (int i = 0; i < arr.length; i++) {
			if (!set.contains(i + 1)) {
				missingNum = i + 1;
				break;
			}
		}
		return missingNum;
	}
	
	public static void main(String[] args) {
		MissingNumberFinder finder = new MissingNumberFinder();
		int[] arr = { 9, 8, 3, 5, 4, 7, 2, 0, 1 };
		int missingElement = finder.findMissingElement(arr);
		System.out.println("Missing number: " + missingElement);
		missingElement = finder.findMissingNumUsingSet(arr);
		System.out.println("Missing number: " + missingElement);
	}
}
