/*
 * 
 * 
 * 
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

/*
 * Given an array of integers 'nums' and an integer 'target', return indices of the two numbers such that they add up to target. You may assume that each input would have exactly one solution, and you may not use the same element twice. You can return the answer in any order.
 */
public class TwoSum {

	public static void main(String[] args) {

		int[] nums = { 2, 7, 11, 15 };
		int target = 9;

		TwoSum twoSum = new TwoSum();
		pairs = twoSum.pairs(nums);

		// Print all possible pairs
		for (HashSet<Integer> pair : pairs) {
			for (Integer i : pair) {
				System.out.print(i + ", ");
			}
			System.out.println();
		}

		targetPair = twoSum.checksum(pairs, target);

		// Print result
		System.out.print("Target Pair: ");
		for (Integer i : targetPair) {
			System.out.print(i + " ");
		}
		System.out.println();

		// Print indices
		indices = twoSum.indices(targetPair, nums);
		System.out.println(indices.toString());

	}

	static HashSet<HashSet<Integer>> pairs;
	static HashSet<Integer> targetPair;
	static ArrayList<Integer> indices;

	/*
	 * Creates every possible pair of numbers from a given array of numbers
	 */
	public HashSet<HashSet<Integer>> pairs(int[] nums) {

		HashSet<HashSet<Integer>> pairs = new HashSet<HashSet<Integer>>();
		for (int i = 0; i < 1000; i++) {
			HashSet<Integer> pair = new HashSet<Integer>();
			while (pair.size() != 2) {
				Random random = new Random();
				int index = random.nextInt(4);
				pair.add(nums[index]);
			}
			pairs.add(pair);
		}
		return pairs;
	}

	/*
	 * Returns a pair of integers if their checksum equals a given target
	 */
	public HashSet<Integer> checksum(HashSet<HashSet<Integer>> pairs, int target) {

		for (HashSet<Integer> pair : pairs) {
			int checksum = 0;
			for (Integer i : pair) {
				checksum += i;
				if (rightTarget(checksum, target)) {
					return pair;
				}
			}
		}
		return null;
	}

	private boolean rightTarget(int checksum, int target) {
		return checksum == target ? true : false;
	}

	public ArrayList<Integer> indices(HashSet<Integer> pair, int[] nums) {

		ArrayList<Integer> indices = new ArrayList<Integer>();
		for (Integer num : pair) {
			for (int i = 0; i < nums.length; i++) {
				if (num == nums[i]) {
					indices.add(i);
				}
			}
		}
		return indices;
	}

}
