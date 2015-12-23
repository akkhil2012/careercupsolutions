package com.recursion;

public class StringSubSets {
	
	public void getSubSets(char[] arr){
		
		getSets(arr,0,arr.length-1);
		
		
		
	}
	
	private void getSets(char[] arr,int start, int end){
		
		if(start == arr.length)return;
		
		System.out.println(" "+ arr[start] +" ");
		
		for(int i=start;i<arr.length-1;i++){
			System.out.println(" "+ arr[start] +" ");
		getSets(arr, i+1, end);
		}
		System.out.println("");
	}
	
	
	
	
	public static void main(String args[]) {
		StringSubSets sets = new StringSubSets();
		int count[] = {2,2,3};
        sets.getSubSets("abc".toCharArray());
	}

}
