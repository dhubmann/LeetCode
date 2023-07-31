/*
 * MissingNumber
 * Represents Missing Number example
 * Author: Daniel Hubmann
 * Last Change: 30.07.2023
 */

package binary;
import java.util.Arrays;

/**
 * Given an array nums containing n distinct numbers in the range [0, n], return
 * the only number in the range that is missing from the array.
 * 
 * @author daniel
 *
 */
public class MissingNumber {

	public static void main(String[] args) {

		int[] nums1 = { 3, 0, 1 };
		int[] nums2 = { 0, 1 };
		int[] nums3 = { 9, 6, 4, 2, 3, 5, 7, 0, 1 };

		int result;
		MissingNumber mN = new MissingNumber();
		result = mN.missingNumber(nums3);
		System.out.println(result);

		result = mN.missingNumber2(nums3);
		System.out.println(result);

		result = mN.missingNumber3(nums3);
		System.out.println(result);

		result = mN.missingNumber4(nums3);
		System.out.println(result);

	}

	/*
	 * Sorting (O(n log n) and iterating/comparing (O(n)) results in time complexity
	 * of O(n log n).
	 */
	public int missingNumber(int[] nums) {
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			if (i != nums[i]) {
				return i;
			}
		}
		return nums.length;
	}

	/*
	 * Alternative solution with time complexity of O(n), calculating difference
	 * between expected checksum (using Gaussian sum formula) and actual checksum.
	 */
	public int missingNumber2(int[] nums) {
		return (nums.length * (nums.length + 1)) / 2 - checkSumArray(nums);
	}

	public static int checkSumArray(int[] nums) {
		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			result += nums[i];
		}
		return result;
	}

	/*
	 * Alternative solution - subtracting indices of complete array [0 - n] from the
	 * given array, adding the remainder to result and returning it. Using only one
	 * for loop and the given array.
	 */
	public int missingNumber3(int[] nums) {
		// initial value needs to be added as the iteration goes only from 0 to n-1
		int result = nums.length;
		for (int i = 0; i < nums.length; i++) {
			result += (i - nums[i]);
		}
		return result;
	}

	/*
	 * Alternative solution using XOR operator
	 */
	public int missingNumber4(int[] nums) {
		// intial value needs to be 1 as it is the smallest possible size
		int result = 1;
		for (int i = 1; i < nums.length; i++) {
			result ^= nums[i] ^ nums[i - 1] ^ nums.length;
		}
		return result;
	}

}
