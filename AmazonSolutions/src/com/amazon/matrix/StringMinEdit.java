package com.amazon.matrix;

/*
 * 
 * http://www.careercup.com/question?id=5926214520799232
 */
public class StringMinEdit {
	public static boolean checkIfMinEdit(String str1, String str2) {
		int first_length = str1.length();
		int sec_length = str2.length();
		int temp[][] = new int[first_length][sec_length];
		for (int i = 0; i < temp.length; i++) {
			temp[i][0] = i;
		}
		for (int i = 0; i < temp[0].length; i++) {
			temp[0][i] = i;
		}
		for (int i = 1; i < str1.length(); i++) {
			for (int j = 1; j < str2.length(); j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					temp[i][j] = 1 + temp[i - 1][j - 1];
				} else {
					temp[i][j] = min(temp[i - 1][j - 1], temp[i][j - 1],
							temp[i - 1][j]);
				}
				if (temp[i][j] > 1)
					return false;
			}
		}
		return true;
	}
	private static int min(int a, int b, int c) {
		int temmp = Math.min(a, b);
		return Math.min(temmp, c);
	}

	public static void main(String args[]) {
		String str1 = "abc";
		String str2 = "ab";
		boolean res = checkIfMinEdit(str1, str2);
		System.out.println(" Boes stringconversion needs more than 1 edits :"
				+ res);
	}
}
