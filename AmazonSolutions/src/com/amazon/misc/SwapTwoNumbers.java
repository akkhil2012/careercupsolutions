package com.amazon.misc;

public class SwapTwoNumbers {
	public void add(int first,int second){
		System.out.println(" Before Swap  "+" first "+ first +" and Second is "+ second);
		second = second - first;
		first = first + second;
		second = first  - second; 
		System.out.println(" first "+ first +" and Second is "+ second);
	}
	
	public static void main(String args[]) {
		new SwapTwoNumbers().add(32,83);
	}
}
