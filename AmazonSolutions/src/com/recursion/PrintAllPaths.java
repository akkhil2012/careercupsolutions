package com.recursion;

public class PrintAllPaths {

	private void printArray(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i] + "  ");
		}
		System.out.println("\n");

	}

	public void print(int[][] mat, int row, int col, int[] result, int pos) {

		if (row == mat.length && col == mat[0].length) {
			result[pos] = mat[row][col];
			printArray(result);
			return;

		}

		if (row > mat.length || col > mat[0].length)
			return;

		result[pos] = mat[row][col];

		print(mat, row, col + 1, result, pos + 1);// Row to Column 
		print(mat, row + 1, col, result, pos + 1);// Column to Row iteration

	}

	public static void main(String args[]) {
		PrintAllPaths pam = new PrintAllPaths();
		int arr[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		int result[] = new int[arr.length + arr[0].length - 1];
		pam.print(arr, 0, 0, result, 0);
	}
}
