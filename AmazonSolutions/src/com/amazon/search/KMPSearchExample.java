package com.amazon.search;

public class KMPSearchExample {
	
	
	
	private static int[] computeTempArray(char pattern[]){
		
		int lps[] = new int[pattern.length];
		
		int index = 0;
		for(int i=1;i<pattern.length-1;i++){
			if(pattern[i] == pattern[index]){
				lps[i] = index +1;
				i++;
				index++;
			}else{
				if(index!=0){
					index = lps[index - 1];
				}else{
				lps[i] = 0;
				i++;
				}
			}
		}
		return lps;
	}
	
	public static boolean  ifPatternPresent(char[] pattern, char[] text){
	  int lps[] = 	computeTempArray(pattern);
	  int i = 0;
	  int j = 0;
	  while(i< text.length && j < pattern.length){
		  if(pattern[j] == text[i]){
			  i++;
			  j++;
		  }else{
			  if(j!=0)
				   j = lps[j-1];
			  else
				  i++;
		  }
	  }
	  
	  if(j == pattern.length)
		  	return true;
		return false;
	}
	
	
	public static void main(String args[]) {
		
		
		
	}

}
