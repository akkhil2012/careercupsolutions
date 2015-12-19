package com.amazon.arrays;

public class SubArrayWithSumInArray {
	public void getSubArray(int[] arr,int sum){
		int add = arr[0]; int start = 0;
			for (int i = 1; i <= arr.length; i++) {
				while (add > sum) {
					add = add - arr[start];
					i++;
				}
				
				if(add == sum)
					System.out.println(" Sum found between "+ );
				
			}
	}
	
	public static void main(String args[]) {
		int[] arr = {1, 4, 20, 3, 10, 5};
		System.out.println(" SubArray starts at ");
		new SubArrayWithSumInArray().getSubArray(arr, 33);
	}
}
