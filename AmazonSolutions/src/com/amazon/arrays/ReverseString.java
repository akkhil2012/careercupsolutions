package com.amazon.arrays;

public class ReverseString {

	public void reverse(String[] arr) {

		for (String str : arr) {
			String st = reverseWord(str);
			System.out.print(" " + st + " ");
		}

	}

	public String reverseWord(String str) {
		String res;
		StringBuffer stBuffer = new StringBuffer();
		for (int i = str.length() - 1; i >= 0; i--) {
			stBuffer.append(str.charAt(i));
		}

		return stBuffer.toString();
	}

	public static void main(String args[]) {

		String str[] = { "This", "is", "an", "example" };

		new ReverseString().reverse(str);

	}

}
