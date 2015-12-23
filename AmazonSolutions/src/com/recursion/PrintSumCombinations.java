package com.recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintSumCombinations {

	public void print(int[] arr, int sum) {
		List<Integer> result = new ArrayList<Integer>();
		print(arr, sum, result);
	}

	private void print(int[] arr, int sum, List<Integer> result) {

		if (sum < 0)
			return;

		if (sum == 0) {
			result.stream().forEach(i -> System.out.print(i + " "));
			System.out.println(" ");
			return;

		}

		for (int i = 0; i < arr.length; i++) {
			result.add(arr[i]);
			print(arr, sum - arr[i], result);
			result.remove(result.size() - 1);
		}

	}

	public static void main(String args[]) {
		int input[] = { 2, 3, 5 };
		PrintSumCombinations psc = new PrintSumCombinations();
		psc.print(input, 10);
	}
}
