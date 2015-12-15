package com.amazon.matrix;

public class MaximumProduct {
	
	
	public static int maxProduct(int[][] mat){
		int max = 0;
		
		
		int[][] temp  = new int[mat.length][mat[0].length];
		
		
		for(int i=0;i<mat.length;i++){
			for(int j=0;j<mat[0].length;j++){
				temp[i][j] = maxim(
						
						mat[i][j]*mat[i][j++]*mat[i][j+2]*mat[i][j+3],
						mat[i++][j+1]*mat[i+2][j+2]*mat[i+3][j+3]*mat[i][j],
								mat[i][j]*mat[i+1][j]*mat[i+2][j]*mat[i+3][j]
						);
				
				if(temp[i][j] > max)
					max = temp[i][j];
			}
		}
		
		return max;
	}
	
	
	
	public static int maxim(int a,int b,int c){
		int temp =Math.max(a, b);
		return Math.max(temp, c);
	}
	
	
	
	
	
	
	public static void main(String args[]) {
		
		int matrix[][] = {{1, 2, 0, -1, 4},
		          {3, 1, 2, 4, 6},
		          {0, 2, 3, 1, 4},
		          {1, 3, 2, 0, 7},
		          {2, 1, 3, 2, 9}
		          };
		
		
		
		System.out.println("Maximum Product is "+ maxProduct(matrix));
		
	}
	

}
