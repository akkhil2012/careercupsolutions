package com.amazon.matrix;

public class AllSquareMatrix {
	
	public void getSquareMatrix(int[][] mat) {
		int sum = 0;
		for (int i = 0; i < mat.length; i++) {
			//m = 0;
			for (int j = 0; j <= i ; j++) {
				for (int k = 0; k < mat.length; k++) {
					sum += mat[j][k];
					System.out.println(" Sum for "+ j +" "+k + " is  " + sum);
				}
			System.out.println(" ");
			}
			System.out.println(" ");
		}
	}
	
	public static void main(String args[]){
		int input[][] = {{1,2,3},
                {4,5,6},
                {7,8,9}};
		new AllSquareMatrix().getSquareMatrix(input);
	}
}
