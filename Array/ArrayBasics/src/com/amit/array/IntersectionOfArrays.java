package com.amit.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author amit
 * Find intersection of two unsorted arrays.
 */
public class IntersectionOfArrays {

	/**
	 * Brute force approach to find intersection of two arrays
	 * @author amit
	 * @param a
	 * @param b
	 */
	public void findIntersectionOfArrays(int[] a, int[] b) {
		int unionArr[] = a.length > b.length ? new int[b.length] : new int[a.length];
		int unionArrIndex = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				if (a[i] == b[j]) {
					unionArr[unionArrIndex] = a[i];
					unionArrIndex++;
				}
			}
		}

		for (int index = 0; index < unionArrIndex; index++) {
			System.out.print(unionArr[index] + "\t");
		}
	}
	
	/**
	 * @author amit
	 * @param a
	 * @param b
	 */
	public void findIntersectionOfArraysUsingSet(int[] a, int[] b) {
		int unionArr[] = a.length > b.length ? new int[b.length] : new int[a.length];
		int unionArrIndex = 0;
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < a.length; i++) {
			set.add(a[i]);
		}

		for (int j = 0; j < b.length; j++) {
			if (set.contains(b[j])) {
				unionArr[unionArrIndex] = b[j];
				unionArrIndex++;
			}
		}
		for (int index = 0; index < unionArrIndex; index++) {
			System.out.print(unionArr[index] + "\t");
		}
	}
	
	public static void main(String[] args) {
		int[] a = { 1, 3, 4, 7, 2, 5 };
		int[] b = { 2, 6, 8, 3, 9, 4 };
		IntersectionOfArrays arrayIntersection = new IntersectionOfArrays();
		arrayIntersection.findIntersectionOfArrays(a, b);
		System.out.println();
		arrayIntersection.findIntersectionOfArraysUsingSet(a, b);
	}
}
