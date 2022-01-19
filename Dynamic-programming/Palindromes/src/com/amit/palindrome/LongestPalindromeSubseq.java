package com.amit.palindrome;

public class LongestPalindromeSubseq {

	public static void main(String[] args) {
		LongestPalindromeSubseq subseq= new LongestPalindromeSubseq();
		System.out.println(subseq.longestPalindromeSubsequence("abdbca"));
		
	}

	public int longestPalindromeSubsequence(String s) {
		Integer[][] dp= new Integer[s.length()][s.length()];
		// return recursiveLongestPalindromeSubsequence(s, 0, s.length() - 1);
		return recursiveLongestPalindromeSubsequence(dp, s, 0, s.length()-1);
	}

	/*
	 * Find longest palindrome subsequence using recursion
	 */
	private int recursiveLongestPalindromeSubsequence(String s, int startIndex, int endIndex) {
		if (startIndex > endIndex)
			return 0;
		if (startIndex == endIndex)
			return 1;

		if (s.charAt(startIndex) == s.charAt(endIndex))
			return 2 + recursiveLongestPalindromeSubsequence(s, startIndex + 1, endIndex - 1);

		int length1 = recursiveLongestPalindromeSubsequence(s, startIndex + 1, endIndex);
		int length2 = recursiveLongestPalindromeSubsequence(s, startIndex, endIndex - 1);
		return Math.max(length1, length2);
	}

	/*
	 * Find longest palindrome subsequence using dynamic programming memoization
	 */
	private int recursiveLongestPalindromeSubsequence(Integer[][] dp, String s, int startIndex, int endIndex) {
		if (startIndex > endIndex)
			return 0;
		if (startIndex == endIndex)
			return 1;

		if (dp[startIndex][endIndex] == null) {
			if (s.charAt(startIndex) == s.charAt(endIndex)) {
				dp[startIndex][endIndex] = 2 + recursiveLongestPalindromeSubsequence(s, startIndex + 1, endIndex - 1);
			} else {
				int length1 = recursiveLongestPalindromeSubsequence(s, startIndex + 1, endIndex);
				int length2 = recursiveLongestPalindromeSubsequence(s, startIndex, endIndex - 1);
				dp[startIndex][endIndex] = Math.max(length1, length2);
			}
		}
		return dp[startIndex][endIndex];
	}
}
