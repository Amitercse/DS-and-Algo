package com.amit.array;

public class RightRotateByOne {

	public static void main(String[] args) {
		RightRotateByOne rotateArray= new RightRotateByOne();
		int arr[]= {1,2,3,4,5};
		int[] output= rotateArray.rightRotateByOne(arr);
		for(int i: output)
		{
			System.out.println(i);
		}
	}
	
	private int[] rightRotateByOne(int[] arr) {
		int temp = arr[arr.length - 1];
		for (int i = arr.length - 2; i >= 0; i--) {
			arr[i + 1] = arr[i];
		}
		arr[0] = temp;
		return arr;
	}
}
