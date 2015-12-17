package com.dynamic;
public class MinimumJumps {
	private static int getJumpsToReachEnd(int[] arr) {
		int res[] = new int[arr.length];
		int[] jump = new int[arr.length];
		int i, j;
		jump[0] = 0;
		for (i = 1; i < arr.length; i++) {
			jump[i] = Integer.MAX_VALUE;
			for (j = 0; j < i; j++) {
				if (i <= j + arr[j] && jump[j] != Integer.MAX_VALUE) {
					jump[i] = Math.min(jump[i], jump[j] + 1);
					break;
				}
			}
		}
		return jump[arr.length - 1];
	}

	public static void main(String args[]) {
		int[] arr = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
		System.out.println(" Minimum number of jumps are " + getJumpsToReachEnd(arr));
	}
}
