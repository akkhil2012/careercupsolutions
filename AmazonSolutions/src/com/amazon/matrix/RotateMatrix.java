package com.amazon.matrix;

import java.util.Scanner;

public class RotateMatrix {
	public void rotate(int[][] matrix){
		int j = 0;
		
		int length = matrix.length-1;
		while(j<matrix.length/2){
		for(int i=0;i<length;i++){
		
		int temp = matrix[i][j];
		matrix[i][j] = matrix[length-i][j];
		matrix[length-i][j] = matrix[length-i][length-j];
		matrix[length-i][length-j] = matrix[i][length-j];
		matrix[i][length-j] = temp;
		//j++;
		}
		j++;
		}
		
		System.out.println(" After rotation ");
		
		
		for (int i = 0; i < matrix.length; i++) {
			for (j = 0; j < matrix[0].length; j++) {
				System.out.print(" " + matrix[i][j] + " ");
			}
			System.out.println(" ");
		}
		
	}

	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		System.out.println(" Enter matrix length ");
		int[][] in  = { { 3, 2, 9, 4 }, { 1, 7, 5, 3 }, { 2, 4, 6, 9 },
				{ 1, 6, 2, 5 } };
/*		int length = scan.nextInt();
		int[][] in = new int[length][length];
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				in[i][j] = scan.nextInt();
			}
			System.out.println(" ");
		}
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				System.out.print(" " + in[i][j] + " ");
			}
			System.out.println(" ");
		}
*/		
		new RotateMatrix().rotate(in);
	}
	
}
