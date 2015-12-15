package com.amazon.string;

public class StringReverse {

	
	
	
	public static void main(String[] str) {
		char[] str1 = "akkhil".toCharArray();
		
		int start = 0;
		int end = str1.length-1;
		
		while(end>start){
			System.out.println(" strat -- "+ str1[start]);
			System.out.println(" end  -- "+ str1[end]);
					str1[start] ^= str1[end];
					System.out.println(" 1  start-- "+ str1[start]);
					str1[end] ^= str1[start];
					System.out.println(" 1  end-- "+ str1[end]);
							str1[start] ^= str1[end];
							start++;
							end--;
		}
		System.out.println(" "+ String.valueOf(str1));
		
	}
}
