/*
 * ValidAnagram
 * Represents Valid Anagram
 * Author: Daniel Hubmann
 * Last Change: 29.07.2023
 */

package string;
import java.util.Arrays;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false
 * otherwise. An Anagram is a word or phrase formed by rearranging the letters
 * of a different word or phrase, typically using all the original letters
 * exactly once.
 * 
 * @author Daniel Hubmann
 * 
 */
public class ValidAnagram {

	public static void main(String[] args) {

		String s = "anagram";
		String t = "nagaram";

		ValidAnagram vA = new ValidAnagram();
		boolean res = vA.validAnagram2(s, t);
		System.out.println(res);

	}

	public boolean validAnagram(String s, String t) {

		char[] arr1 = s.toCharArray();
		char[] arr2 = t.toCharArray();

		Arrays.sort(arr1);
		Arrays.sort(arr2);

		return Arrays.equals(arr1, arr2);
	}

	/*
	 * Alternative solution adding and subtracting each occurence of a letter to a
	 * position in an array. Resulting array needs to be all zeros for a valid
	 * anagram.
	 */
	public boolean validAnagram2(String s, String t) {

		int[] count = new int[256];
		if (s.length() != t.length()) {
			return false;
		}

		for (int i = 0; i < s.length(); i++) {
			count[s.charAt(i)]++;
			count[t.charAt(i)]--;
		}

		for (int i = 0; i < count.length; i++) {
			if (count[i] != 0) {
				return false;
			}
		}

		return true;
	}

}
