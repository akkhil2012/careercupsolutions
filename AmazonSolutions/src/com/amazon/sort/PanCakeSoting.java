package com.amazon.sort;

public class PanCakeSoting {

	private static int findMaxElementIndex(int[] arr, int size) {
		int index = 0;
		for (int i = 1; i < size; i++) {
			if (arr[i] > arr[index])
				index = i;
		}
		return index;
	}

	public static void pansorting(int[] arr) {
		for (int currSize = arr.length; currSize > 1; --currSize) {
			int maxIndex = findMaxElementIndex(arr, currSize);
			if (maxIndex != currSize - 1) {
				flip(arr, maxIndex);// Sort partiall so as to put value at max Index to last
				flip(arr, currSize - 1);// excluding the last element sort again
			}
		}
	}

	private static void flip(int arr[], int num) {
		int start = 0;
		int temp;
		while (start < num) {// this part of array is to be reversed as per
								// defination of pancake sorting
			temp = arr[start];
			arr[start] = arr[num];
			arr[num] = temp;
			start++;
			num--;
		}
	}

	public static void main(String args[]) {
		int[] arr = { 23, 10, 20, 11, 12, 6, 7 };
		pansorting(arr);
		for (int i : arr) {
			System.out.print(" " + i + " ");
		}
	}
}
