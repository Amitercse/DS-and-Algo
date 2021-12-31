package com.amit.array;

public class RearrangePositiveNegative {

	public static void main(String[] args) {
		RearrangePositiveNegative rearrange= new RearrangePositiveNegative();
		int[] arr= {-1,-3, 20,4,5,-9,-6};
		int[] output= rearrange.rearrangePositiveNegative(arr);
		for(int i: output)
		{
			System.out.print(i+ "\t");
		}
	}
	
	private int[] rearrangePositiveNegative(int[] arr) {
		int firstPositiveIndex = -1;
		for (int i = 0; i < arr.length; i++) {
			if (firstPositiveIndex == -1 && arr[i] > 0) {
				firstPositiveIndex = i;
			} else if (arr[i] < 0 && firstPositiveIndex != -1) {
				arr[i] = arr[i] + arr[firstPositiveIndex];
				arr[firstPositiveIndex] = arr[i] - arr[firstPositiveIndex];
				arr[i] = arr[i] - arr[firstPositiveIndex];
				firstPositiveIndex++;
			}
		}
		return arr;
	}
}
