package com.amazon.arrays;
/*
 * 
 * http://www.careercup.com/question?id=5120301346062336
 * 
 */
public class FirstLastOccuranceInArray {
	public void numberOfOccurances(int[] arr, int num) {
		int low = 0;
		int high = arr.length - 1;
		while (low <= high && arr[low] != num) {
			low++;
		}
		int lower = low;
		if (low <= high) {
			while (low <= high && (arr[low] == arr[low + 1])) {
				low = low + 1;
			}
			System.out.println(" First occurance at " + lower
					+ " last occurance at " + low);
		} else
			System.out.println(" Element NOT present ");
	}

	public static void main(String args[]) {
		int[] arr = { 1, 2, 2, 3, 4, 4, 5, 6, 6, 6, 6, 6, 6 };
		new FirstLastOccuranceInArray().numberOfOccurances(arr, 4);
	}
}
