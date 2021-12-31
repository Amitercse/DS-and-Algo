package com.amit.array;

public class MaxSumSubArray {
	
	public static void main(String[] args) {
		MaxSumSubArray maxSumSubArray= new MaxSumSubArray();
		int[] arr= {1, 7, -2, -5, 10, -1};
		int max = maxSumSubArray.maxSumSubArray(arr);
		System.out.println(max);
	}

	private int maxSumSubArray(int[] arr)
	{
		int globalMax=0;
		if(arr== null || arr.length==0)
		{
			return 0;
		}
		else
		{
			int currentMax= arr[0];
			globalMax= arr[0];
			for(int i=1; i<arr.length; i++)
			{
				if(currentMax<0)
				{
					currentMax= arr[i];
				}
				else
				{
					currentMax= currentMax+arr[i];
				}
				if(globalMax<currentMax)
				{
					globalMax= currentMax;
				}
			}
		}
		return globalMax;
	}
}
