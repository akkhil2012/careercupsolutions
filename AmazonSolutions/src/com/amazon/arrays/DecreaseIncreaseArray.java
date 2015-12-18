package com.amazon.arrays;

import java.util.Arrays;
public class DecreaseIncreaseArray {
	private static void getOrderChanged(int[] arr) {
		int n = arr.length - 1;
		int temp = 0;
		Arrays.sort(arr);
		for (int i = 1; i < n; i += 2) {
			if (i + 1 < n) {
				temp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = temp;
			}
		}
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	public static void main(String args[]) {
		int[] arr = { 0, 6, 9, 13, 10, -1, 8, 2, 4, 14, -5 };
		getOrderChanged(arr);
	}
}
