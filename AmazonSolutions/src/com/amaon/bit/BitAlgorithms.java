package com.amaon.bit;

public class BitAlgorithms {
	public int getNumberRepeatingOnce(int[] arr) {
		int number = arr[0];
		for (int i = 1; i < arr.length; i++) {
			number ^= arr[i];
		}
		return number;
	}

	public static void main(String args[]) {
		int arr[] = { 3,3,2,3 };
		System.out.println(" Number appearing only once is "
				+ new BitAlgorithms().getNumberRepeatingOnce(arr));
	}
}
