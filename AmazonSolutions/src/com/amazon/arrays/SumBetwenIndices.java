package com.amazon.arrays;

/*
 * any better complexity that O(m+n-1)
 * http://www.careercup.com/question?id=5707919444148224
 */
public class SumBetwenIndices {
	public int findSumIndices(int[] arr, int i, int j) {
		int sum = 0;
		int index = 0;
		if (j + 1 > arr.length)
			return 0;
		for (index = i; index <= j; index++) {
			sum += arr[index];
		}
		return sum;
	}

	public static void main(String args[]) {
		int arr[] = { 1,2,3,4,5,6,71,2,3,4 };
		System.out.println(" Sum between indices "
				+ new SumBetwenIndices().findSumIndices(arr, 3, 6));
	}
}
