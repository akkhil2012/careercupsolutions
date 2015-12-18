package com.amazon.arrays;

public class LargestSubArray {

	int maxSize = 0;
	int startIndex = 0;

	public int subArray(int[] arr) {
		int ones = 0;
		int zeros = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] == 1)
				ones++;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == 0) {
					zeros++;
				}
				if (ones == zeros && maxSize < j - i + 1) {
					maxSize = j - i + 1;
					startIndex = i;
				}
			}
		}
		return (maxSize == -1) ? 0 : startIndex;
	}

	public static void main(String args[]) {
		int[] arr = { 0, 0, 1, 1, 0 };

		System.out.println("LargestSubArray length is "
				+ new LargestSubArray().subArray(arr));
	}

}
