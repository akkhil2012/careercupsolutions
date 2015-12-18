package com.amazon.arrays;

import java.util.HashSet;
import java.util.Set;

public class DuplicatesWithinKIndices {
	private boolean checkIfDuplicates(int[] arr, int k) {
		Set<Integer> visited = new HashSet<Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (visited.contains(arr[i])) {
				return true;
			}
			if (i >= k) {
				visited.remove(arr[i - k]);
			}
			visited.add(arr[i]);
		}
		return false;
	}

	public static void main(String args[]) {

		int arr[] = { 1, 2, 3, 11, 2, 5, 6 };
		int k = 2;

		System.out.println(" Are duplicates present "
				+ new DuplicatesWithinKIndices().checkIfDuplicates(arr, k));
	}

}
