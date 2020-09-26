package com.amit.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author amit
 * Program to find multiple duplicate numbers in array.
 */
public class MultipleDuplicateFinder {

	/**
	 * Find duplicate entries using brute force approach.
	 * @author amit
	 * @param arr
	 */
	public void findMultipleDuplicates(int[] arr) {
		// Using set to store duplicate entries.
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					set.add(arr[i]);
				}
			}
		}
		System.out.println("duplicate enteries using brute force: ");
		for (Integer i : set) {
			System.out.print(i + "\t");
		}
	}
	
	/**
	 * Find duplicate entries in the array after sorting the array.
	 * @author amit
	 * @param arr
	 */
	public void findMultipleDuplicatesUsingSort(int[] arr) {
		Arrays.sort(arr);
		Set<Integer> set = new HashSet<Integer>();
		int previous = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (previous == arr[i]) {
				set.add(arr[i]);
			} else {
				previous = arr[i];
			}
		}
		System.out.println("Duplicate entries using sort: ");
		for (Integer i : set) {
			System.out.print(i + "\t");
		}
	}
	
	/**
	 * Find duplicate entries in array using map. It needs iterations 
	 * twice, but only in linear complexity. Extra space needed for map.
	 * @author amit
	 * @param arr
	 */
	public void findMultipleDuplicatesUsingMap(int[] arr) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				int count = map.get(arr[i]);
				map.put(arr[i], count + 1);
			} else {
				map.put(arr[i], 1);
			}
		}
		System.out.println("duplicate entries using map: ");
		for (Integer i : map.keySet()) {
			if (map.get(i) > 1) {
				System.out.print(i + "\t");
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 2, 5, 6, 3, 7, 5, 2, 8, 3, 5, 2 };
		MultipleDuplicateFinder finder = new MultipleDuplicateFinder();
		finder.findMultipleDuplicates(arr);
		System.out.println();
		finder.findMultipleDuplicatesUsingSort(arr);
		System.out.println();
		finder.findMultipleDuplicatesUsingMap(arr);
	}
}
