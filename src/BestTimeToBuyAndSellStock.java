/*
 * BestTimeToBuyAndSellStock
 * Represents Best Time to Buy and Sell Stock example
 * Author: Daniel Hubmann
 * Last Change: 01.08.2023
 */

/**
 * You are given an array prices where prices[i] is the price of a given stock
 * on the ith day.
 * 
 * You want to maximize your profit by choosing a single day to buy one stock
 * and choosing a different day in the future to sell that stock.
 * 
 * Return the maximum profit you can achieve from this transaction. If you
 * cannot achieve any profit, return 0.
 * 
 * @author daniel
 *
 */
public class BestTimeToBuyAndSellStock {

	public static void main(String[] args) {

		int[] prices1 = { 7, 5, 6, 3, 1, 0 }; // max profit: 1
		int[] prices2 = { 6, 5, 4, 3, 1, 1 }; // max profit: 0

		BestTimeToBuyAndSellStock main = new BestTimeToBuyAndSellStock();
		int result;
		result = main.bestTime(prices1);
		System.out.println(result);
		result = main.bestTime(prices2);
		System.out.println(result);

		result = main.bestTime2(prices1);
		System.out.println(result);
		result = main.bestTime2(prices2);
		System.out.println(result);
	}

	/*
	 * Alternative solution - more efficient as time complexity is at O(n) using
	 * 'two pointers technique'. The left pointer gets updated when the value at the
	 * right pointer is lower. But the max profit only gets updated if a new max
	 * profit is found.
	 */
	public int bestTime2(int[] prices) {
		int left = 0;
		int right = 1;
		int maxProfit = 0;
		while (right < prices.length) {
			if (prices[left] > prices[right]) {
				left = right;
				right += 1;
			} else {
				maxProfit = (prices[right] - prices[left]) > maxProfit ? (prices[right] - prices[left]) : maxProfit;
				right += 1;
			}
		}
		return maxProfit;
	}

	/*
	 * First solution - iterate over the array and determine positions in the array
	 * from which on the array has ascending values. Then determine the biggest
	 * difference between the values. Worst case time complexity is O(n²) though -
	 * not efficient.
	 */
	public int bestTime(int[] prices) {
		int profit, maxProfit = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			if (prices[i] > prices[i + 1]) {
				continue;
			}
			for (int j = i; j < prices.length; j++) {
				if (prices[j] - prices[i] > 0) {
					profit = prices[j] - prices[i];
					if (profit > maxProfit) {
						maxProfit = profit;
					}
				}
			}
		}
		return maxProfit;
	}

}
