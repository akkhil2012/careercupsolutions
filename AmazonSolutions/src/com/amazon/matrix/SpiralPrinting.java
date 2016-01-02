package com.amazon.matrix;

public class SpiralPrinting {
	public void printSpiral(int[][] mat){
	
		
		char[][] temp = new char[mat.length][mat[0].length];
		
		int left = 0;
		int right = mat[0].length - 1;
		
		int top = 0;
		int down = mat.length -1;
		
		while(right>left && top <down ){
			
			for(int i=left;i<=right;i++){
			//	System.out.print(" "+ mat[top][i]);
				if(top%2==0)
				temp[top][i] = '*';
				else
				temp[top][i] = 'o';
				
			}
			top++;
			
			for(int i=top;i<=down;i++){
				//System.out.print(" "+ mat[j][right]);
				if(right%2==0)
					temp[i][right] = '*';
					else
					temp[i][right] = 'o';
				
			}
			right--;
			
			for(int i=right;i>=0;i--){
				//System.out.print(" "+ mat[down][i]);
				if(down%2==0)
					temp[down][i] = '*';
					else
					temp[down][i] = 'o';
			}
			down--;
			
			for(int i=down;i>=top;i--){
				//System.out.print(" "+ mat[i][left]);
				if(left%2==0)
					temp[i][left] = '*';
					else
					temp[i][left] = 'o';
			}
			left++;
		}
		
		System.out.println(" Afgget spiral printing ---- >> ");
		
		for(int i=0;i<temp.length;i++){
			for(int j=0;j<temp[0].length;j++){
				System.out.print(" "+ temp[i][j]+" ");
			}
			System.out.println(" ");
		}
		
	}

	
	public static void main(String args[]) {
		
		int matrix[][] = {{1,2,3,4},{6,7,8,9},{11,12,13,14},{16,17,18,19}};
		
		new SpiralPrinting().printSpiral(matrix);
		
		
		
	}
	
	
	
	
	
	
	
	
}
