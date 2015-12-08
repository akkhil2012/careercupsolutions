package com.amazon.misc;

public class FindSquareRoot {

	public static void root(int num) {

		for (int i = 0; i < num; i++) {
			while (i * i != num) {
				i++;
			}
			System.out.println(" Root is " + i);
		}

	}

	public static void main(String args[]) {

		new FindSquareRoot().root(16);

	}

}
