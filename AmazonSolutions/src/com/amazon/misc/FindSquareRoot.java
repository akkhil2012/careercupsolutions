package com.amazon.misc;
/*
		http://www.careercup.com/question?id=5658483003228160
*/
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
