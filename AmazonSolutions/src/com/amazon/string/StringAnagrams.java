package com.amazon.string;

public class StringAnagrams {
	
	
	public static void getAnagrams(String str){
		
		int inLength = str.length();
		boolean[] used = new boolean[inLength];
		StringBuffer outputString = new StringBuffer();
		char[] in = str.toCharArray();
		
		doPermute(in,outputString,used,inLength,0);
		
		
	}
	
	
	
	public static void doPermute(char[] in,StringBuffer outputString,boolean[] used,int inputLength,int level){
		
		if(level==inputLength){
			System.out.println(" "+outputString.toString());
			return;
		}
		
		for(int i=0;i<inputLength;++i){
			
			if(used[i]) continue;
			
			outputString.append(in[i]);
			used[i] = true;
			
			doPermute(in, outputString, used, inputLength, level+1);
			used[i] = false;
			
			outputString.setLength(outputString.length()-1);
			
		}
		
		
		
		
	}
	
	
	
	
	
	
	public static void main(String args[]) {
		
		getAnagrams("java");
		
	}

}
