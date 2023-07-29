/*
 * NumberOfOneBits
 * Represents Number of 1 Bits Example
 * Author: Daniel Hubmann
 * Last Change: 29.07.2023
 */

/**
 * Write a function that takes the binary representation of an unsigned integer
 * and returns the number of '1' bits it has (also known as the Hamming weight).
 * 
 * @author Daniel Hubmann
 *
 */
public class NumberOfOneBits {

	public static void main(String[] args) {

		// 00000000000000000000000000001011
		String n0 = "101";
		String n1 = "00000000000000000000000000001011";
		String n2 = "00000000000000000000000010000000";
		String n3 = "11111111111111111111111111111101";

//		System.out.println(hammingWeight(n0));
//		System.out.println(hammingWeight(n1));
//		System.out.println(hammingWeight(n2));
//		System.out.println(hammingWeight(n3));

		int int0 = 0b101;
		int int1 = 0b00000000000000000000000000001011;
		int int2 = 0b00000000000000000000000010000000;
		int int3 = 0b11111111111111111111111111111101;
		int mask = 0b11111111111111111111111111111111;

//		System.out.println(hammingWeight(int0));

		System.out.println(hammingWeightShifting(int3));

	}
	
	/*
	 * Since the input is always a 32 bit integer, the time complexity is constant
	 * with O(32).
	 */
	public static int hammingWeight(int input) {
		int counter = 0;
		while (input != 0) {
			counter += (input % 2);
			input = input >> 1;
		}
		return counter;
	}

	/*
	 * Alternative solution using bitwise AND operator
	 */
	public static int hammingWeightShifting(int input) {
		int counter = 0;
		while (input != 0) {
			int temp = input - 1;
			input = input & temp;
			counter++;
		}
		return counter;
	}
	
	public static int hammingWeight(String input) {
		int counter = 0;
		for (int i = 0; i < input.length(); i++) {
			char bit = input.charAt(i);
			if (bit == '1') {
				counter = counter + 1;
			}
		}
		return counter;
	}

}
