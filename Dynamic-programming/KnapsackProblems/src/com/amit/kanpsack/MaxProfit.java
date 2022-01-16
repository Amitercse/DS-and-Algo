package com.amit.kanpsack;

public class MaxProfit {

	public int findMaxProfitInKnapSack(int[] profits, int[] weights, int capacity) {
		return findMaxProfit(profits, weights, capacity, 0);
	}

	private int findMaxProfit(int[] profits, int[] weights, int capacity, int currentItem) {
		if (capacity <= 0 || currentItem >= profits.length) {
			return 0;
		}
		int profit1 = 0;
		if (weights[currentItem] <= capacity) {
			profit1 = profits[currentItem]
					+ findMaxProfit(profits, weights, capacity - weights[currentItem], currentItem + 1);
		}
		int profit2 = findMaxProfit(profits, weights, capacity, currentItem + 1);

		return Math.max(profit1, profit2);
	}

	public static void main(String[] args) {
		MaxProfit maxProfitKnapsack = new MaxProfit();
	    int[] profits = {1, 6, 10, 16};
	    int[] weights = {1, 2, 3, 5};
	    int maxProfit = maxProfitKnapsack.findMaxProfitInKnapSack(profits, weights, 7);
	    System.out.println("Total knapsack profit ---> " + maxProfit);
	    maxProfit = maxProfitKnapsack.findMaxProfitInKnapSack(profits, weights, 6);
	    System.out.println("Total knapsack profit ---> " + maxProfit);
	}
}
