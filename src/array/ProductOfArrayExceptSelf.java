package array;
/*
 * ProductOfArrayExceptSelf
 * Represents Product of Array Except Self example
 * Author: Daniel Hubmann
 * Last Change: 30.07.2023
 */

/**
 * Given an integer array nums, return an array answer such that answer[i] is
 * equal to the product of all the elements of nums except nums[i].
 * 
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit
 * integer.
 * 
 * You must write an algorithm that runs in O(n) time and without using the
 * division operation.
 * 
 * @author daniel
 *
 */
public class ProductOfArrayExceptSelf {

	public static void main(String[] args) {

		int[] nums1 = { 1, 2, 3, 4 };
		int[] nums2 = { -1, 1, 0, -3, 3 };

		ProductOfArrayExceptSelf main = new ProductOfArrayExceptSelf();

		printArray(main.productExceptSelf(nums1));
		printArray(main.productExceptSelf2(nums1));
		printArray(main.productExceptSelf3(nums1));
		printArray(main.productExceptSelf(nums2));
		printArray(main.productExceptSelf2(nums2));
		printArray(main.productExceptSelf3(nums2));

	}

	/*
	 * Alternative solution with time complexity of O(2n) without using division
	 * operator but iterating twice, once from front to back, once from back to
	 * front calculating the product up to each number once from the front and once
	 * from the back.
	 */
	public int[] productExceptSelf3(int[] nums) {
		int[] answer = new int[nums.length];
		int prefix = 1;
		for (int i = 0; i < nums.length; i++) {
			answer[i] = prefix;
			prefix *= nums[i];
		}
		int postfix = 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			answer[i] *= postfix;
			postfix *= nums[i];
		}
		return answer;
	}

	/*
	 * Alternative solution with time complexity of O(2n) and using the
	 * multiplication operator with the reciprocal values - probably not the point
	 * of the exercise.
	 * 
	 * TODO: incorrect - does not work with arrays containing 0s f. ex. nums2
	 */
	public int[] productExceptSelf2(int[] nums) {
		int[] answer = new int[nums.length];
		int product = 1;
		for (int i = 0; i < nums.length; i++) {
			product *= nums[i];
		}
		for (int i = 0; i < nums.length; i++) {
			answer[i] = (int) (product * ((float) 1 / nums[i]));
		}
		return answer;
	}

	/*
	 * Solution with time complexity of O(n²) - not efficient.
	 */
	public int[] productExceptSelf(int[] nums) {
		int[] answer = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			int product = 1;
			for (int j = 0; j < nums.length; j++) {
				if (i != j) {
					product *= nums[j];
				}
			}
			answer[i] = product;
		}
		return answer;
	}

	public static void printArray(int[] input) {
		System.out.print("[");
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i]);
			if (i != input.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.print("]");
		System.out.println();
	}

}
