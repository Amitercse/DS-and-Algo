package com.amit.palindrome;

public class LongestPalindromeSubstring {

	public static void main(String[] args) {
		LongestPalindromeSubstring palindrome= new LongestPalindromeSubstring();
		System.out.println(palindrome.longestCommonSubstring("abdbca"));
	}
	
	public int longestCommonSubstring(String s) {
	//	return recursiveLongestCommonSubstring(s, 0, s.length() - 1);
		Integer[][] dp= new Integer[s.length()][s.length()];
		return recursiveLongestCommonSubstring(dp, s, 0, s.length() - 1);
	}

	/*
	 * Find longest palindrome substring via recursion
	 */
	private int recursiveLongestCommonSubstring(String s, int startIndex, int endIndex) {
		if (startIndex > endIndex)
			return 0;
		if (startIndex == endIndex)
			return 1;

		if (s.charAt(startIndex) == s.charAt(endIndex)) {
			int remainingLength = endIndex - startIndex - 1;
			if (remainingLength == recursiveLongestCommonSubstring(s, startIndex + 1, endIndex - 1)) {
				return remainingLength + 2;
			}
		}
		int c1 = recursiveLongestCommonSubstring(s, startIndex + 1, endIndex);
		int c2 = recursiveLongestCommonSubstring(s, startIndex, endIndex - 1);
		return Math.max(c1, c2);
	}

	/*
	 * Find longest palindrome substring via dynamic programming memoization
	 */
	private int recursiveLongestCommonSubstring(Integer[][] dp, String st, int startIndex, int endIndex) {
		if (startIndex > endIndex)
			return 0;

		// every string with one character is a palindrome
		if (startIndex == endIndex)
			return 1;

		if (dp[startIndex][endIndex] == null) {
			// case 1: elements at the beginning and the end are the same
			if (st.charAt(startIndex) == st.charAt(endIndex)) {
				int remainingLength = endIndex - startIndex - 1;
				// check if the remaining string is also a palindrome
				if (remainingLength == recursiveLongestCommonSubstring(dp, st, startIndex + 1, endIndex - 1)) {
					dp[startIndex][endIndex] = remainingLength + 2;
					return dp[startIndex][endIndex];
				}
			}
			// case 2: skip one character either from the beginning or the end
			int c1 = recursiveLongestCommonSubstring(dp, st, startIndex + 1, endIndex);
			int c2 = recursiveLongestCommonSubstring(dp, st, startIndex, endIndex - 1);
			dp[startIndex][endIndex] = Math.max(c1, c2);
		}
		return dp[startIndex][endIndex];
	}
}
