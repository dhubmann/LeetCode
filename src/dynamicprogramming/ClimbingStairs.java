/*
 * ClimbingStairs
 * Represents Climbing Stairs example
 * Author: Daniel Hubmann
 * Last Change: 30.07.2023
 */

package dynamicprogramming;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * 
 * @author daniel
 *
 */
public class ClimbingStairs {

	public static void main(String[] args) {

		ClimbingStairs cS = new ClimbingStairs();

		int result;
		result = cS.climbStairs(1);
		System.out.println(result);

		result = cS.climbStairs(2);
		System.out.println(result);

		result = cS.climbStairs(3);
		System.out.println(result);

		result = cS.climbStairs(4);
		System.out.println(result);

		result = cS.climbStairs(5);
		System.out.println(result);

		result = cS.climbStairs(6);
		System.out.println(result);

		result = cS.climbStairs(7);
		System.out.println(result);

	}

	public int climbStairs(int n) {
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		return climbStairs(n - 1) + climbStairs(n - 2);
	}

}
