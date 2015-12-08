package com.amazon.arrays;
/*
 * 
 * http://www.careercup.com/question?id=5697297964859392
 */
public class RepeatedCountsInArray {
	public static void getCount(int[] arr) {
		for (int i = 1; i < arr.length-1; ) {
			int count = 1;
			int j=i-1;
			if (arr[j] == arr[j + 1] ) {
				while (arr[j] == arr[j + 1]) {
					count++;
					i++;
				}
				//i = j;
				System.out.println(arr[j] + " is repeated " + count + " times");
			} else {
				i++;
			}
		}
	}
	
	public static void main(String args[]) {
		int arr[] = {1,2,7,7,7,7,8,8,8};
		new RepeatedCountsInArray().getCount(arr);
	}
}
