package com.amit.array;

/**
 * @author amit
 * Finding union of two sorted arrays.
 * Here using one approach only that will take O(m+n) time.
 */
public class UnionOfSortedArrays {

	/**
	 * Expected that both the arrays are sorted.
	 * @author amit
	 * @param a
	 * @param b
	 */
	public void findUnion(int[] a, int[] b) {
		int[] unionArr = new int[a.length + b.length];
		int unionArrIndex = 0;
		int i = 0, j = 0;
		int m = a.length;
		int n = b.length;
		while (i < m && j < n) {
			if (a[i] < b[j]) {
				unionArr[unionArrIndex] = a[i];
				i++;
			} else if (a[i] > b[j]) {
				unionArr[unionArrIndex] = b[j];
				j++;
			} else {
				// Here a[i]==b[j]
				unionArr[unionArrIndex] = b[j];
				i++;
				j++;
			}
			unionArrIndex++;
		}
		/**
		 * Since both arrays may not be of same length and for loop may exit before
		 * iterating over both arrays. So copying existing elements also of largest
		 * array. If any of the array is iterated completely then while loop will not
		 * execute.
		 */
		while (i < m) {
			unionArr[unionArrIndex] = a[i];
			i++;
			unionArrIndex++;
		}
		while (j < n) {
			unionArr[unionArrIndex] = b[j];
			j++;
			unionArrIndex++;
		}
		// Print union array.
		for (int index = 0; index < unionArrIndex; index++) {
			System.out.print(unionArr[index] + "\t");
		}
	}
	
	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 6, 8, 10 };
		int b[] = { 2, 4, 5, 6, 7, 9, 11 };
		UnionOfSortedArrays unionOfArrays = new UnionOfSortedArrays();
		unionOfArrays.findUnion(a, b);
	}
}
