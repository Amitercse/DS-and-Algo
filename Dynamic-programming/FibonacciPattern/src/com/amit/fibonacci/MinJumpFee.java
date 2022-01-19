package com.amit.fibonacci;

public class MinJumpFee {

	public static void main(String[] args) {
		MinJumpFee minJump = new MinJumpFee();
		int[] fee = { 1, 2, 5, 2, 1, 2 };
		System.out.println(minJump.findMinFee(fee));
		fee = new int[] { 2, 3, 4, 5 };
		System.out.println(minJump.findMinFee(fee));
	}

	public int findMinFee(int[] fee) {
	//	return minJumpFeeRecursive(fee, 0);
		Integer[] dp= new Integer[fee.length];
		return minJumpFeeMemoization(dp, fee, 0);
	}

	private int minJumpFeeRecursive(int[] fee, int currentIndex) {
		if (currentIndex >= fee.length)
			return 0;

		int oneStepFee = minJumpFeeRecursive(fee, currentIndex + 1);
		int twoStepsFee = minJumpFeeRecursive(fee, currentIndex + 2);
		int threeStepsFee = minJumpFeeRecursive(fee, currentIndex + 3);

		int minFee = Math.min(Math.min(oneStepFee, twoStepsFee), threeStepsFee);
		return minFee + fee[currentIndex];
	}
	
	private int minJumpFeeMemoization(Integer[] dp, int[] fee, int currentIndex) {
		if (currentIndex >= fee.length)
			return 0;

		if (dp[currentIndex] == null) {
			int oneStepFee = minJumpFeeMemoization(dp, fee, currentIndex + 1);
			int twoStepsFee = minJumpFeeMemoization(dp, fee, currentIndex + 2);
			int threeStepsFee = minJumpFeeMemoization(dp, fee, currentIndex + 3);

			int minFee = Math.min(Math.min(oneStepFee, twoStepsFee), threeStepsFee);
			minFee = minFee + fee[currentIndex];
			dp[currentIndex] = minFee;
		}
		return dp[currentIndex];
	}

}
