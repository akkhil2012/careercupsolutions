package com.amazon.arrays;

class MaxRepeating {
	public int maxRepeating(int[] arr, int length, int range) {
		for (int i = 0; i < length; i++) {
			arr[arr[i] % range] += range;
		}

		int max = arr[0];
		int result = 0;
		for (int i = 1; i < length; i++) {
			if (arr[i] > max) {
				max = arr[i];
				result = i;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int arr[] = { 2, 3, 3, 5, 3, 4, 1, 7, 4, 4, 4, 4, 4 };
		int n = arr.length - 1;
		int k = 8;
		System.out.println("Maximum repeating element is: "
				+ new MaxRepeating().maxRepeating(arr, n, k));
	}
}
