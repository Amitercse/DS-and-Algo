package com.amit.array;

/**
 * @author amit
 */
public class IntersectionOfSortedArrays {

	/**
	 * Assuming that arrays are sorted.
	 * @param a
	 * @param b
	 */
	public void findIntersectionofArrays(int[] a, int[] b) {
		int unionArr[] = a.length > b.length ? new int[b.length] : new int[a.length];
		int unionArrIndex = 0;
		int i = 0, j = 0;
		int m = a.length;
		int n = b.length;
		while (i < m && j < n) {
			if (a[i] > b[j]) {
				j++;
			} else if (a[i] < b[j]) {
				i++;
			} else {
				unionArr[unionArrIndex] = a[i];
				i++;
				j++;
				unionArrIndex++;
			}
		}
		for (int index = 0; index < unionArrIndex; index++) {
			System.out.print(unionArr[index] + "\t");
		}
	}
	
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 7 };
		int[] b = { 2, 3, 4, 6, 8, 9 };
		IntersectionOfSortedArrays arrayIntersection = new IntersectionOfSortedArrays();
		arrayIntersection.findIntersectionofArrays(a, b);
	}
}
