package com.dynamic;

public class MaximmumSumNonAdjacent {

	
	private static int getSum(int[] arr) {
		int excl = 0;
		int inclu = arr[0];
		for (int i = 1; i < arr.length; i++) {
			int temp = inclu;
			inclu = Math.max(excl + arr[i], inclu);
			excl = temp;
		}
		return inclu;
	}	
	
	
	
	
	public static void main(String args[]) {
		
		int[] arr = {};
		
		
		System.out.println(" Maximum sum is "+getSum(arr));
	}
}
