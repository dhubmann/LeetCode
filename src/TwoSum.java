/*
 * TwoSum
 * Represents Two Sum Example
 * Author: Daniel Hubmann
 * Last Change: 07.07.2023
 */

import java.util.HashSet;

/*
 * Given an array of integers 'nums' and an integer 'target', return indices of the two numbers such that they add up to target. You may assume that each input would have exactly one solution, and you may not use the same element twice. You can return the answer in any order.
 */
public class TwoSum {

	public static void main(String[] args) {

		int[] nums = { 2, 7, 11, 15 };
		int target = 9;

		TwoSum twoSum = new TwoSum();

		indices = twoSum.checksum(nums, target);
		System.out.println(indices);
		
	}
	
	static HashSet<Integer> indices;

	/*
	 * Method has O(n²) - find more efficient solution
	 */
	public HashSet<Integer> checksum(int[] nums, int target) {

		HashSet<Integer> indices = new HashSet<Integer>();

		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (nums[i] != nums[j] && (nums[i] + nums[j]) == target) {
					indices.add(i);
				}
			}
		}

		return indices;
	}

}
