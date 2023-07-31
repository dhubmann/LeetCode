package array;
/*
 * TwoSum
 * Represents Two Sum Example
 * Author: Daniel Hubmann
 * Last Change: 07.07.2023
 */

import java.util.HashMap;
import java.util.HashSet;

/**
 * Given an array of integers 'nums' and an integer 'target', return indices of
 * the two numbers such that they add up to target. You may assume that each
 * input would have exactly one solution, and you may not use the same element
 * twice. You can return the answer in any order.
 */
public class TwoSum {

	public static void main(String[] args) {

		int[] nums = { 2, 7, 11, 15 };
		int target = 9;

		TwoSum twoSum = new TwoSum();

		// Solution 1
		indicesSet = twoSum.checksum(nums, target);
		System.out.println(indicesSet);

		// Solution 2
		indicesArray = twoSum.check(nums, target);
		twoSum.printArray(indicesArray);

	}

	static HashSet<Integer> indicesSet;
	static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	static int[] indicesArray = new int[2];

	/*
	 * More efficient solution - O(n)
	 */
	public int[] check(int[] nums, int target) {

		int[] indices = new int[2];

		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				indices[0] = map.get(target - nums[i]);
				indices[1] = i;
			} else {
				map.put(nums[i], i);
			}
		}

		return indices;

	}

	public void printArray(int[] array) {
		System.out.print("[");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			if (i != array.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
	}

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
