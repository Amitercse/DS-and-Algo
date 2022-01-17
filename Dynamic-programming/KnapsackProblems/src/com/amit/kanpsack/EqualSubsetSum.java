package com.amit.kanpsack;

public class EqualSubsetSum {

	public static void main(String[] args) {
		EqualSubsetSum ps = new EqualSubsetSum();
		int[] num = { 1, 2, 3, 4 };
		System.out.println(ps.equalSumSubSet(num));
		num = new int[] { 1, 1, 3, 4, 7};
		System.out.println(ps.equalSumSubSet(num));
		num = new int[] { 2, 3, 4, 6 };
		System.out.println(ps.equalSumSubSet(num));
	}

	public boolean equalSumSubSet(int[] num) {
		int sum = 0;
		for (int i = 0; i < num.length; i++)
			sum += num[i];

		// if 'sum' is a an odd number, we can't have two subsets with equal sum
		if (sum % 2 != 0)
			return false;

		Boolean[][] dp = new Boolean[num.length][sum / 2 + 1];
		return this.equalSumSubsetPartition(dp, num, sum / 2, 0);
	}

	private boolean equalSumSubsetPartition(Boolean[][] dp, int[] num, int sum, int currentIndex) {
		if (sum == 0)
			return true;
		if (currentIndex >= num.length)
			return false;

		if (dp[currentIndex][sum] == null) {
			if (num[currentIndex] <= sum) {
				if (equalSumSubsetPartition(dp, num, sum - num[currentIndex], currentIndex + 1)) {
					dp[currentIndex][sum] = true;
					return true;
				}
			}
			dp[currentIndex][sum] = equalSumSubsetPartition(dp, num, sum, currentIndex + 1);
		}
		return dp[currentIndex][sum];
	}
}
