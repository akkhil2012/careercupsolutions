package com.amazon.arrays;

public class ArrayMedian {
	/*
	 * 
	 * 
	 * http://www.careercup.com/question?id=5630219643781120: Alternative approach BST Heap implementation left ........TO DO
	 */
	public int findMedian(int[] arr) {
		quickSort(arr, 0, arr.length - 1);
		for (int it : arr) {
			System.out.print("" + it + " ");
		}
		if (arr.length % 2 != 0)
			return arr[arr.length / 2];
		else {
			return (arr[arr.length / 2] + arr[arr.length / 2 + 1]) / 2;
		}
	}

	private void quickSort(int[] arr, int low, int high) {
		int i = low;
		int j = high;
		int pivot = (low + high) / 2;
		while (i <= j) {
			while (arr[i] < arr[pivot]) {
				i++;
			}
			while (arr[j] > arr[pivot]) {
				j--;
			}
			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
		if (i < high)
			quickSort(arr, i, high);
		if (j > low)
			quickSort(arr, low, j);
	}

	public static void main(String args[]) {
		int arr[] = { 20, 45, 67, 75, 76, 78, 83, 88, 89, 91, 98, 99 };
		System.out.println(" Median is " + new ArrayMedian().findMedian(arr));
	}
}
