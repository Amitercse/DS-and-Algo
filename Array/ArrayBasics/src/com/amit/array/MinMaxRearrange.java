package com.amit.array;

public class MinMaxRearrange {

	public static void main(String[] args) {
		MinMaxRearrange rearrange= new MinMaxRearrange();
		int arr[]= {1,2,3,4,5,6,7};
		int output[]= rearrange.maxMinReArrange(arr);
		for(int i: output)
		{
			System.out.print(i+"\t");
		}
	}
	
	private int[] maxMinReArrange(int[] arr) {
		if (arr == null || arr.length == 0) {
			return arr;
		}
		int last = arr.length - 1;
		int output[] = new int[arr.length];
		int j = 0;
		int i = 0;
		while (i <= last) {
			if (i == last) {
				output[j] = arr[last];
				last--;
			} else {
				output[j++] = arr[last];
				output[j++] = arr[i];
				last--;
				i++;
			}
		}
		return output;
	}

}
