/*
 * TwoPointersSum
 * Represents example with two pointers technique (not a LeetCode example)
 * Author: Daniel Hubmann
 * Last Change: 01.08.2023
 */

package other;

public class TwoPointersSum {

	public static void main(String[] args) {

		int[] arr1 = { 10, 20, 35, 50, 75, 80 };
		TwoPointersSum main = new TwoPointersSum();

		boolean result;
		result = main.containsSum(arr1, 30); // true
		System.out.println(result);
		result = main.containsSum(arr1, 50); // false
		System.out.println(result);
		result = main.containsSum(arr1, 55); // true
		System.out.println(result);
		result = main.containsSum(arr1, 101); // false
		System.out.println(result);

		Result r = new Result();
		r = main.containsSum2(arr1, 90); // true
		System.out.println(r.contains + ", " + r.counter);
		r = main.containsSum2(arr1, 50); // false
		System.out.println(r.contains + ", " + r.counter);
		r = main.containsSum2(arr1, 60); // true
		System.out.println(r.contains + ", " + r.counter);
		r = main.containsSum2(arr1, 101); // false
		System.out.println(r.contains + ", " + r.counter);

	}

	public Result containsSum2(int[] array, int sum) {
		Result result = new Result();
		int left = 0;
		int right = array.length - 1;
		while (left < right) {
			result.counter++;
			if (array[left] + array[right] == sum) {
				result.contains = true;
				return result;
			} else if (array[left] + array[right] > sum) {
				right -= 1;
			} else if (array[left] + array[right] < sum) {
				left += 1;
			}
		}
		return result;
	}

	public boolean containsSum(int[] array, int sum) {
		int left = 0;
		int right = array.length - 1;
		while (left < right) {
			if (array[left] + array[right] == sum) {
				return true;
			} else if (array[left] + array[right] > sum) {
				right -= 1;
			} else if (array[left] + array[right] < sum) {
				left += 1;
			}
		}
		return false;
	}

}
