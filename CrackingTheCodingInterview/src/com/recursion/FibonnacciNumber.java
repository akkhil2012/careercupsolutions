package com.recursion;

public class FibonnacciNumber {
	public static int getSeriesRec(int num) {
		if (num == 0)
			return 0;
		else if (num == 1)
			return 1;
		else if (num > 1)
			return getSeriesRec(num-1) + getSeriesRec(num-2);
		else {
			return -1;
		}
	}
	
	
	public static int getSeriesItr(int num) {
		int a = 1, b = 1;
		for (int i = 0; i <= num; i++) {
			int c = a + b;
			a = b;
			b = c;
		}
		return b;
	}

	public static void main(String args[]) {
		System.out.println(" FIBB is " + getSeriesRec(5));
	}
}
