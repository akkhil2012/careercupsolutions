package com.amaon.bit;

public class AddNumbers {
	public int add(int x, int y) {
		
		while (y != 0)
	    {
	        // carry now contains common set bits of x and y
	        int carry = x & y;  
	        System.out.println(" carry   "+ Integer.toBinaryString(carry));
	 
	        // Sum of bits of x and y where at least one of the bits is not set
	        x = x ^ y;
	        System.out.println(" x   "+ Integer.toBinaryString(x));
	 
	        // Carry is shifted by one so that adding it to x gives the required sum
	        y = carry << 1;
	        System.out.println(" y   "+ Integer.toBinaryString(y));
	    }
	    return x;

		
	}
	public static void main(String args[]) {
		
		System.out.println(" Add value is "+ Integer.toBinaryString(new AddNumbers().add(15, 32)));
		
	}
}
