/*
 * ThreeSum
 * Represents Three Sum Example
 * Author: Daniel Hubmann
 * Last Change: 09.07.2023
 */

import java.util.HashMap;
import java.util.HashSet;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j],
 * nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] +
 * nums[k] == 0.
 * 
 * Notice that the solution set must not contain duplicate triplets.
 * 
 * @author Daniel Hubmann
 *
 */
public class ThreeSum {

	public static void main(String[] args) {

		ThreeSum tS = new ThreeSum();

		int[] nums_1 = { -1, 0, 1, 2, -1, 4 };
		int[] nums_2 = { 0, 1, 1 };
		int[] nums_3 = { 0, 0, 0 };

	}

	public boolean containsEntry(HashMap<Integer, Integer> triplet, Integer index, Integer value) {
		if (triplet.containsKey(index) && triplet.containsValue(value)) {
			return true;
		}
		return false;
	}

	public boolean checksumIsZero(HashMap<Integer, Integer> triplet) {
		ThreeSum tS = new ThreeSum();
		if (tS.checksumOfHashMap(triplet) == 0) {
			return true;
		}
		return false;
	}

	public Integer checksumOfHashMap(HashMap<Integer, Integer> triplet) {
		Integer result = 0;
		for (Integer value : triplet.values()) {
			result = result + value;
		}
		return result;
	}

	public int checksumOfArray(int[] nums) {
		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			result += nums[i];
		}
		return result;
	}

}
