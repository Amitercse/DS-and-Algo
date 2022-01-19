package com.amit.fibonacci;

public class PossibleWays {

	public static void main(String[] args) {
		PossibleWays possibleWays = new PossibleWays();
		System.out.println(possibleWays.possibleWays(4));
		System.out.println(possibleWays.possibleWays(5));
	}
	
	/*
	 * Find possible ways to represent n as sum of 1,3 and 4
	 */
	public int possibleWays(int n) {
		if (n <= 0) {
			System.out.println("invalid input");
			return 0;
		}
		return possibleRecursiveWays(n);
	}
	
	private int possibleRecursiveWays(int n) {
		if (n == 0)
			return 1;
		if (n == 1)
			return 1;
		if (n == 2)
			return 1;
		if (n == 3)
			return 2;
		return possibleRecursiveWays(n - 1) + possibleRecursiveWays(n - 3) + possibleRecursiveWays(n - 4);
	}
}
