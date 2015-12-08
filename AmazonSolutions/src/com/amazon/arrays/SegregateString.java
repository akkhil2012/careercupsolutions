package com.amazon.arrays;
/*
 * 
 * http://www.careercup.com/question?id=5647284379320320
 */
public class SegregateString {
	
	public static void segregate(String str){
		char[] chArray = str.toCharArray();
		int low = 0;
		int  mid = 0;
		int high = chArray.length-1;
		while(mid <= high){
			if(chArray[low]>=97 && chArray[low]<=122){
				 char temp = chArray[mid++];
				 chArray[mid++] = chArray[low++];
				 chArray[low++] = temp;
			  break;	
			}
			if(chArray[mid] == 32){
				  mid++;
				  break;
			  }
			 if(chArray[high]>=65 && chArray[high]<=90){
			
				 char temp = chArray[mid];
				 chArray[mid] = chArray[high--];
				 chArray[high--] = temp;
				  break;
			  }
		}
	    for(int i=0;i<chArray.length;i++){
			System.out.print(" "+chArray[i]+" ");
		    	}
		}
	
	
	public static  void swap(char a,char b){
		
	}
		
	
	
	
	public static void main(String arg[]) {
		
		String str = "a cBd LkmY";
		new SegregateString().segregate(str);
	}

}
