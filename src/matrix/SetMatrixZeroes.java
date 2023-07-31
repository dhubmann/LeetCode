/*
 * SetMatrixZeroes
 * Represents Set Matrix Zeroes example
 * Author: Daniel Hubmann
 * Last Change: 31.07.2023
 */

package matrix;

/**
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row
 * and column to 0's.
 * 
 * You must do it in place.
 * 
 * @author daniel
 *
 */
public class SetMatrixZeroes {

	public static void main(String[] args) {

		int[][] matrix1 = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
		SetMatrixZeroes main = new SetMatrixZeroes();

	}

	public int[][] setMatrixZeroes(int[][] matrix) {

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {

//				if (matrix[i][j] == 0) {
//					for (int k = 0; k < matrix[i].length; k++) {
//						matrix[i][k] = 0;
//					}
//					break;
//				}
			}
		}

		return matrix;
	}

	public boolean containsZero(int[] row) {

		int index = -1;
		for (int i = 0; i < row.length; i++) {
			if (row[i] == 0) {
				for (int j = 0; j < row.length; j++) {
					row[j] = 0;
				}
				break;
			}
		}

		return false;
	}

}
