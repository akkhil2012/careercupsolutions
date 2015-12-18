package com.amazon.arrays;

public class MinimumDistanceBetween {
	public int getDistanceBetween(int[] arr, int first, int second) {
		int minDis = Integer.MAX_VALUE;
		int j = 0;
		int temp = 0;
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == first || arr[i] == second) {
				 temp = arr[i];
				j = i;
				break;
			}
		}
				for (int i = j; i < arr.length; i++) {
					if (arr[i] == first || arr[i] == second) {
						if (arr[i] != temp) {
							if (minDis > i - j){
								minDis = i - j;
							}
							j = i;
						}
						
					}
				}
			
		return minDis;
	}
	
	public static void main(String args[]) {
		int[] arr = {2, 5, 3, 5, 4, 4, 2, 3};
		System.out.println(" Min distance is " + new MinimumDistanceBetween().getDistanceBetween(arr, 3, 2));
	}
}
