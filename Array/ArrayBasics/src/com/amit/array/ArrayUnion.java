package com.amit.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author amit
 * Class to find union of two arrays. Union array will have all
 * data of first and second array but not repeated one.
 * Assuming that an array doesn't have duplicate records. 
 */
public class ArrayUnion {

	/**
	 * Find union of array using brute force approach
	 * @author amit
	 * @param a
	 * @param b
	 * @return
	 */
	public void findUnionOfArrays(int[] a, int[] b) {
		int unionArr[] = new int[a.length + b.length];
		for (int i = 0; i < a.length; i++) {
			unionArr[i] = a[i];
		}
		int unionArrIndex = a.length;
		for (int i = 0; i < b.length; i++) {
			boolean elementAlreadyAdded = findElementInArr(a, b[i]);
			if (!elementAlreadyAdded) {
				unionArr[unionArrIndex] = b[i];
				unionArrIndex++;
			}
		}
		for (int index = 0; index < unionArrIndex; index++) {
			System.out.print(unionArr[index]+"\t");
		}
	}
	
	/**
	 * Search an element in array
	 * @author amit
	 * @param arr
	 * @param element
	 * @return
	 */
	private boolean findElementInArr(int[] arr, int element) {
		boolean foundElement = false;
		for (int i = 0; i < arr.length; i++) {
			if (element == arr[i]) {
				foundElement = true;
				break;
			}
		}
		return foundElement;
	}
	
	/**
	 * Finding union of array using hash set
	 * @author amit
	 * @param a
	 * @param b
	 */
	public void findUnionOfArraysUsingHash(int a[], int b[]) {
		int[] unionArr = new int[a.length + b.length];
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < a.length; i++) {
			unionArr[i] = a[i];
			set.add(a[i]);
		}
		int unionArrIndex = a.length;
		for (int j = 0; j < b.length; j++) {
			if (!set.contains(b[j])) {
				unionArr[unionArrIndex] = b[j];
				unionArrIndex++;
			}
		}
		for (int index = 0; index < unionArrIndex; index++) {
			System.out.print(unionArr[index] + "\t");
		}
	}
	
	public static void main(String[] args) {
		int a[] = { 1, 2, 7, 6, 5, 3, 8 };
		int b[] = { 2, 9, 3, 10, 11, 4, 5, 12 };
		ArrayUnion arrayUnion= new ArrayUnion();
		arrayUnion.findUnionOfArrays(a, b);
		System.out.println();
		arrayUnion.findUnionOfArraysUsingHash(a, b);
	}
}
