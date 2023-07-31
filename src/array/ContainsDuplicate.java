package array;
/*
 * ContainsDuplicate
 * Represents Contains Duplicate Example
 * Author: Daniel Hubmann
 * Last Change: 07.07.2023
 */

import java.util.HashSet;

/**
 * Given an integer array 'nums', return true if any value appears at least
 * twice in the array, and return false if every element is distinct.
 * 
 * @author Daniel Hubmann
 *
 */
public class ContainsDuplicate {

	public static void main(String[] args) {

		int[] _1231 = { 1, 2, 3, 1 }; // result: true
		int[] _1234 = { 1, 2, 3, 4 }; // result: false

		// Solution 1
		ContainsDuplicate cd = new ContainsDuplicate();
		boolean result = cd.containsDuplicate(_1231);
		System.out.println(result);

		// Solution 2
		boolean resultNestedForLoops = cd.containsDuplicateNestedForLoops(_1231);
		System.out.println(resultNestedForLoops);

	}

	/*
	 * Comparing each number against a set containing visited numbers - runtime
	 * complexity of O(n).
	 */
	public boolean containsDuplicate(int[] nums) {

		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i])) {
				return true;
			} else {
				set.add(nums[i]);
			}
		}

		return false;
	}

	/*
	 * Comparing each number with every number - runtime complexity of O(n²).
	 */
	public boolean containsDuplicateNestedForLoops(int[] nums) {

		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (i != j && nums[i] == nums[j]) {
					return true;
				}
			}
		}

		return false;
	}

}
