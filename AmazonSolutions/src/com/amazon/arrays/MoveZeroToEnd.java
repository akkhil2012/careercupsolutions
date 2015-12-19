package com.amazon.arrays;

public class MoveZeroToEnd {

	
	public void moveToEnd(int[] arr){
		
		int count = 0;
		
		
		for(int i=0;i<arr.length;i++){
			
			if(arr[i] !=0){
				arr[count++]  = arr[i];
			}
			
			
			
		}
		while(count<arr.length){
			arr[count++] = 0;
		}
		
		//System.out.println(" z --"+ zeros+" non zeros are "+ nonZero);
		
		
		
		
	}
	
	
	public static void main(String args[]) {
		
		int[] arr = {0, 0, 0, 2, 7, 0, 6, 0, 9};
		
		new MoveZeroToEnd().moveToEnd(arr);
	}
	
	
	
	
	
	
	
}
