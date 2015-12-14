package com.array;

import java.text.DecimalFormat;

class SetSubset{
	public void getSubSets(String str){
		int k = 0;
		DecimalFormat s = new DecimalFormat("#0.0000");
		System.out.println("--"+s.format(23.44444444));
		for(int i=0;i<=str.length()-1;i++){
			String sub = str.substring(i);
			for(int j=0;j<=sub.length()-1;j++){
				System.out.print(" "+ sub.substring(j,sub.length()-1-k)+" ");
			}
			k=0;
		}
	}
}


public class SubSetsArray {
	public static void main(String args[]) {

		new SetSubset().getSubSets("abc");
		
	}
}
