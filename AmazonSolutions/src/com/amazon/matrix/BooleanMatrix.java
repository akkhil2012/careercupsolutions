package com.amazon.matrix;

public class BooleanMatrix {

	public void redefine(int[][] mat) {

		boolean row[] = new boolean[mat.length];
		boolean col[] = new boolean[mat[0].length];

		for (int i = 0; i < mat.length; i++)
			for (int j = 0; j < mat.length; j++) {
				if (mat[i][j] == 1) {
					row[i] = true;
					col[j] = true;
				}
			}

		for (int i = 0; i < mat.length; i++)
			for (int j = 0; j < mat.length; j++) {
				if (row[i] || col[j])
					mat[i][j] = 1;

			}

	}

	public static void main(String arg[]) {
		int[][] mat = { { 1, 0, 0, 1 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 }, };

		for (int i = 0; i < mat.length; i++){
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(" " + mat[i][j] + " ");
			}
			System.out.println(" ");
		}
		
		System.out.println(" After replacing matrix with 1s ");
		
		new BooleanMatrix().redefine(mat);

		for (int i = 0; i < mat.length; i++){
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(" " + mat[i][j] + " ");
			}
			System.out.println(" ");
		}
	}
		

}
