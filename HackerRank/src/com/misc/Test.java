package com.misc;

public class Test {

	public static void main(String args[]) {
		
		int stairs = 6;
		int m = stairs-1;
		while(m!=0){
			System.out.print(" ");
			m--;
		}
		for (int i = 1; i <= stairs; i++) {
			int k = i;
			
			while (k != 0) {
				System.out.print("#");
				k--;
			}
			System.out.println(" ");
		}
	}
	
}
