package com.amazon.arrays;

public class NumbersWithMaximumProduct {
	public int getProduct(int[] arr){
		int max = Integer.MIN_VALUE;
		int product =1;
		int count = 0;
		for(int i=3;i<arr.length;i++){
			for(int j=0;j<i;j++){
				if(count<4){
				if(arr[j] < arr[j+1]){
				product *= arr[j];
				
				}
				count++;
				}
			}
			if(product > max){
				max = product;
			}
		}
		return max;
	}
	
	
	
	public static void main(String args[]) {
		int[] arr = {6, 7, 8, 1, 2, 3, 9, 10};
		System.out.println(" Maximum product is "+  new NumbersWithMaximumProduct().getProduct(arr));
	}
}


