package com.amazon.arrays;

import java.util.Scanner;

public class Solution {

	public static int calculateUtil(int X) {
		int y = 1;
		while (true) {
			String str = String.valueOf(X * y);
			if (Character.getNumericValue(str.charAt(0)) % 4 == 0) {
				if (str.length() == 1) {
					return Integer.parseInt(str);
				} else {
					for (int i = 1; i < str.length(); i++) {
						if (Character.getNumericValue(str.charAt(i))/ 4 == 1
								|| (Character.getNumericValue(str.charAt(i)) == 0)) {
							return Integer.parseInt(str);
						}
					}
				}
			} else {
				y++;
			}
		}
	}

	public static int calculate(int X) {
		int product = calculateUtil(X);
		int zeros = 0;
		int fours = 0;

		int result = 0;
		char[] productArray = String.valueOf(product).toCharArray();

		for (int i = 0; i < productArray.length; i++) {
			if (Character.getNumericValue(productArray[i]) == 0)
				zeros++;
			else
				fours++;
		}

		result = 2 * fours + zeros;
		return result;

	}

	public static void main(String args[]) throws Exception {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT */

		Scanner scan = new Scanner(System.in);
		System.out.println(" enter");
		int T = scan.nextInt();
		// System.out.println(" T is "+ T);
		while (T != 0) {
			int X = scan.nextInt();
			// System.out.println(" X is "+ X);

			System.out.println(calculate(X));
			T--;
		}
		scan.close();
	}
}