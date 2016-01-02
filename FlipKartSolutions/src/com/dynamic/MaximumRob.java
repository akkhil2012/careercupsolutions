package com.dynamic;

public class MaximumRob {

	public int getMaximum(int[] arr) {
		int excl = 0;
		int incl = arr[0];
		int newExcl;
		for (int i = 1; i < arr.length; i++) {
			newExcl = (excl > incl) ? excl : incl;
			incl = excl + arr[i];
			excl = newExcl;
		}

		return (excl > incl) ? excl : incl;
	}

	public static void main(String args[]) {

		int[] arr = { 10, 2, 3, 5, 7, 8 };

		System.out.println(" Maximum sum is "
				+ new MaximumRob().getMaximum(arr));
	}
}
