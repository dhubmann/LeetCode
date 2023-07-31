/*
 * CountingBits
 * Represents Counting Bits example
 * Author: Daniel Hubmann
 * Last Change: 30.07.2023
 */

package binary;

/**
 * Given an integer n, return an array ans of length n + 1 such that for each i
 * (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
 * 
 * @author Daniel Hubmann
 *
 */
public class CountingBits {

	public static void main(String[] args) {

		CountingBits cB = new CountingBits();
		printArray(cB.bitsArray2(10));
		printArray(cB.bitsArray3(10));

	}

	/*
	 * Solution using .bitCount-method of Integer class - not the point of the
	 * exercise though
	 */
	public int[] bitsArray(int input) {
		int[] ans = new int[input + 1];
		for (int i = 0; i < ans.length; i++) {
			int bitCount = Integer.bitCount(i);
			ans[i] = bitCount;
		}
		return ans;
	}

	/*
	 * Alternative solution
	 */
	public int[] bitsArray2(int input) {
		int[] ans = new int[input + 1];
		for (int i = 0; i < ans.length; i++) {
			int count = 0;
			int temp = i;
			do {
				if (temp % 2 == 1) {
					count++;
				}
				temp = temp / 2;
			} while (temp != 0);
			ans[i] = count;
		}
		return ans;
	}

	/*
	 * Alternative solution - keeping track of the MSB, the bit count is always at
	 * least 1 (except at position 0) + the previously calculated bit counts.
	 */
	public int[] bitsArray3(int input) {
		int[] ans = new int[input + 1];
		int offset = 1; // initial value of MSB (power of 2)
		ans[0] = 0;
		for (int i = 1; i < ans.length; i++) {
			if (i == offset * 2) {
				offset = i;
			}
			ans[i] = 1 + ans[i - offset];
		}
		return ans;
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
