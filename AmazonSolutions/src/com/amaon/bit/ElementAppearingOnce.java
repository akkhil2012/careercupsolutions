package com.amaon.bit;

public class ElementAppearingOnce {
	public void check(int num){
		
		System.out.println(" Num "+ Integer.toBinaryString(num));
		
		int temp = num << 1;
		
		System.out.println("  Negation   "+  Integer.toBinaryString(temp));
	}
	
	
	
	
	
	
	public static void main(String args []) {
		
			new ElementAppearingOnce().check(-83);
	}
}



