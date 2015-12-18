package com.common.arrays;

public class ArrayAddition {
	private static boolean checkIfConsecutive(int[] arr) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
		}

		for (int i = 0; i < arr.length; i++) {
			if (Math.abs(arr[i]) - min >= arr.length)
				return false;
			if (Math.abs(arr[i]) - min < 0)
				return false;
			arr[Math.abs(arr[i]) - min] = -arr[Math.abs(arr[i]) - min];
		}

		for (int i = 0; i < arr.length; i++) {
			arr[i] = Math.abs(arr[i]);
		}
		return true;
	}

	public static void main(String args[]) {

		int[] arr = { 1, 2, 3, 4, 5, 7 };

		System.out.println(" Check if consecutiver " + checkIfConsecutive(arr));

	}
}
