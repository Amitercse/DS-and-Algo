package com.amit.fibonacci;

public class HouseThief {

	public static void main(String[] args) {
		HouseThief ht = new HouseThief();
		int[] wealth = { 2, 5, 1, 3, 6, 2, 4 };
		System.out.println(ht.stealMax(wealth));
		wealth = new int[] { 2, 10, 14, 8, 1 };
		System.out.println(ht.stealMax(wealth));
	}

	public int stealMax(int[] wealth) {
	//	return stealMaxRecursive(wealth, 0);
		Integer[] dp= new Integer[wealth.length];
		return stealMaxRecursiveMemoization(dp, wealth, 0);
	}

	private int stealMaxRecursive(int[] wealth, int currentHouse) {
		if (currentHouse >= wealth.length)
			return 0;
		int stealCurrent = wealth[currentHouse] + stealMaxRecursive(wealth, currentHouse + 2);
		int skipCurrent = stealMaxRecursive(wealth, currentHouse + 1);
		return Math.max(stealCurrent, skipCurrent);
	}

	private int stealMaxRecursiveMemoization(Integer[] dp, int[] wealth, int currentHouse) {
		if (currentHouse >= wealth.length)
			return 0;

		if (dp[currentHouse] == null) {
			int stealCurrent = wealth[currentHouse] + stealMaxRecursive(wealth, currentHouse + 2);
			int skipCurrent = stealMaxRecursive(wealth, currentHouse + 1);
			dp[currentHouse] = Math.max(stealCurrent, skipCurrent);
		}
		return dp[currentHouse];
	}
}
