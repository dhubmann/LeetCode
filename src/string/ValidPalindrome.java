/*
 * ValidPalindrome
 * Represents Valid Palindrome example
 * Author: Daniel Hubmann
 * Last Change: 01.08.2023
 */

package string;

import java.util.Scanner;

/**
 * A phrase is a palindrome if, after converting all uppercase letters into
 * lowercase letters and removing all non-alphanumeric characters, it reads the
 * same forward and backward. Alphanumeric characters include letters and
 * numbers.
 * 
 * Given a string s, return true if it is a palindrome, or false otherwise
 * 
 * @author daniel
 *
 */
public class ValidPalindrome {

	public static void main(String[] args) {

		ValidPalindrome vP = new ValidPalindrome();
		vP.run();

	}

	private static Scanner scanner = new Scanner(System.in);

	public void run() {
		System.out.println("HI!");
		int n = 0;
		do {
			System.out.print("Enter amount: ");
			try {
				n = Integer.parseInt(scanner.nextLine());
			} catch (Exception e) {
				continue;
			}
		} while (n < 1);

		for (int i = 0; i < n; i++) {
			application();
		}
		System.out.println("BYE!");
	}

	public static void application() {
		System.out.print("Enter a string: ");
		String answer;
		answer = scanner.nextLine();
		boolean result;
		result = validPalindrome(cleanString(answer));
		System.out.printf(result ? "%s is a palindrome\n" : "%s is not a palindrome\n", answer);
	}

	/*
	 * First solution using recursion
	 */
	public static boolean validPalindrome(String s) {

		if (s.length() == 0 || s.length() == 1) {
			return true;
		}

		if (s.charAt(0) == s.charAt(s.length() - 1)) {
			s = s.substring(1, s.length() - 1);
			return validPalindrome(s);
		}

		return false;
	}

	/*
	 * Converts string to all lowercase and removes any non-alphanumeric characters
	 */
	public static String cleanString(String s) {
		return s.toLowerCase().replaceAll("[^a-z0-9]", "");
	}

}
