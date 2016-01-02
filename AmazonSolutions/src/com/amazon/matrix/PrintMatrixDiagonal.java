package com.amazon.matrix;

public class PrintMatrixDiagonal {
	public void printDiagonal(int[][] mat){
		int temp[][] = new int[mat.length][mat[0].length];
		int k=0;
		int p = 0;
		for(int i= 0;i<mat.length;i++){
			for(int j= 0;j<mat.length-i +1;j++){
				temp[i][j] = mat[i][j];
			}
		}
		System.out.println(" After Diagonal Shift ");
		for(int i=0;i<temp.length;i++){
			for(int j=0;j<temp[0].length;j++){
				System.out.print(" "+ temp[i][j]+" ");
			}
			System.out.println(" ");
		}
	}
	
	
	public static void main(String args[]) {
		int mat[][] = {{1, 2, 3},
                {4,5, 6},
                {9, 10, 11, 12},
                {7, 8, 9},
               };
		new PrintMatrixDiagonal().printDiagonal(mat);
	}
}
