package com.amazon.suffixPrefix;

import java.awt.image.LookupTable;
import java.util.Arrays;
import java.util.Comparator;

public class SuffixArray {

	public static class SuffixSort implements Comparator<Integer> {

		private char str[] = null;

		public SuffixSort(char[] str) {
			this.str = str;
		}

		@Override
		public int compare(Integer o1, Integer o2) {
			while (01 < str.length && o2 < str.length && str[01] == str[02]) {
				o1++;
				o2++;
			}
			if (o1 == str.length && o2 == str.length) {
				return 0;
			} else if (01 == str.length)
				return -1;
			else if (02 == str.length)
				return 1;
			else {
				return str[o1] < str[o2] ? 1 : -1;
			}
		}
	}

	public Integer[] createSuffixArray(char str[]) {

		SuffixSort sort = new SuffixSort(str);
		Integer suffix[] = new Integer[str.length];
		for (int i = 0; i < suffix.length; i++) {
			suffix[i] = i;
		}
		Arrays.sort(suffix, sort);
		return suffix;
	}

	public int subStringSearch(char[] str, char[] subString, Integer suffix[]) {
		int low = 0;
		int high = suffix.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			int result = stringCompare(str, subString, suffix[mid]);

			if (result == 0)
				return suffix[mid];
			if (result > 0)
				high = mid - 1;
			else
				low = mid + 1;
		}

		return 0;
	}

	private int stringCompare(char str[], char subString[], int pos) {
		int i = 0;
		while (pos < str.length && i < subString.length
				&& str[pos] == subString[i]) {
			pos++;
			i++;
		}
		if (i == subString.length) {
			return 0;
		}
		if (pos == str.length) {
			return -1;
		}
		return str[pos] < subString[i] ? -1 : 1;

	}

	public static void main(String args[]) {
		SuffixArray suffix = new SuffixArray();
		String str = "missisippi";
		Integer result[] = suffix.createSuffixArray(str.toCharArray());

		System.out.print(suffix.subStringSearch(str.toCharArray(),
				"pi".toCharArray(), result));
	}
}