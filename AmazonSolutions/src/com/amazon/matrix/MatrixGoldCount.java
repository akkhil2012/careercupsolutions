package com.amazon.matrix;

import java.util.Scanner;

/*
 * 
 * http://www.careercup.com/question?id=5707163630567424
 * Alter: Does right means vertical and horizontal Only //Can't be diagnol
 */

class GoldMatrix {
	int calculateGold(int[][] mat) {
		int total = 0;
		int[][] tempMat = new int[mat.length + 1][mat[0].length + 1];
		for (int i = 0; i < mat.length; i++) {
			tempMat[i][0] = mat[i][0];
		}
		for (int i = 0; i < mat[0].length; i++) {
			tempMat[0][i] = mat[0][i];
		}
		for (int i = 1; i < tempMat.length - 1; i++) {
			for (int j = 1; j < tempMat[0].length - 1; j++) {
				tempMat[i][j] = mat[i][j]
						+ max(tempMat[i - 1][j], tempMat[i - 1][j - 1],
								tempMat[i - 1][j + 1]);
				if (tempMat[i][j] > total)
					total = tempMat[i][j];
			}
		}
		return total;
	}
	int max(int first, int sec, int third) {
		int temp = Math.max(first, sec);
		return Math.max(temp, third);
	}
}

public class MatrixGoldCount {
	public static void main(String args[]) {
		int[][] mat = { { 3, 2, 9, 4 }, { 1, 7, 5, 3 }, { 2, 4, 6, 9 },
				{ 1, 6, 2, 5 } };
		System.out.println(" Total gold collectable "
				+ new GoldMatrix().calculateGold(mat));
	}
}
