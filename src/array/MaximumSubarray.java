/*
 * MaximumSubarray
 * Represents Maximum Subarray Example
 * Author: Daniel Hubmann
 * Last Change: 30.07.2023
 */

package array;

/**
 * Given an integer array nums, find the subarray with the largest sum, and
 * return its sum.
 * 
 * @author Daniel Hubmann
 *
 */
public class MaximumSubarray {

	public static void main(String[] args) {

		MaximumSubarray mS = new MaximumSubarray();

		int[] nums_1 = { 1 };
		int[] nums_2 = { 1, 2, 3 };
		int[] nums_3 = { -1, 2, 3 };
		int[] nums_4 = { 2, -1, 3 };
		int[] nums_5 = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int[] nums_6 = { 5, 4, -1, 7, 8 };

		System.out.println(mS.compareSubarrays(nums_6));

	}

	/*
	 * Looking for the two lowest numbers in the array and dividing the array into
	 * three subarrays. Then calculating the checksum of the three parts and return
	 * the subarray with the highest checksum.
	 */
	public int compareSubarrays(int[] nums) {
		int indexMin = indexOfMinimum(nums);
		int indexSecondMin = indexOfSecondMinimum(nums, indexMin);
		int max = Integer.MIN_VALUE;

		if (indexMin < indexSecondMin) {
			swap(indexMin, indexSecondMin);
		}

		// Case 1:
		if (calculateChecksumOfArray(nums, 0, indexSecondMin - 1) > max) {
			max = calculateChecksumOfArray(nums, 0, indexSecondMin - 1);
		}

		// Case 2:
		if (calculateChecksumOfArray(nums, indexSecondMin + 1, indexMin - 1) > max) {
			max = calculateChecksumOfArray(nums, indexSecondMin + 1, indexMin - 1);
		}

		// Case 3:
		if (calculateChecksumOfArray(nums, indexMin + 1, nums.length - 1) > max) {
			max = calculateChecksumOfArray(nums, indexMin + 1, nums.length - 1);
		}

		// Case 4:
		if (calculateChecksumOfArray(nums, 0, nums.length - 1) > max) {
			max = calculateChecksumOfArray(nums, 0, nums.length - 1);
		}

		return max;
	}

	public static int calculateChecksumOfArray(int[] nums, int start, int end) {
		int result = 0;
		for (int i = start; i <= end; i++) {
			result += nums[i];
		}
		return result;
	}

	public static int indexOfMinimum(int[] nums) {
		int min = Integer.MAX_VALUE;
		int index = -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < min) {
				min = nums[i];
				index = i;
			}
		}
		return index;
	}

	public static int indexOfSecondMinimum(int[] nums, int index) {
		int secondMin = Integer.MAX_VALUE;
		int firstIndex = index;
		int secondIndex = -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < secondMin && i != firstIndex) {
				secondMin = nums[i];
				secondIndex = i;
			}
		}
		return secondIndex;
	}

	public static void swap(int a, int b) {
		int temp;
		temp = a;
		a = b;
		b = temp;
	}

}
