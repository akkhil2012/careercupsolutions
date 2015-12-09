package com.amazon.arrays;

public class SumOfSubSequence {
	
	public static int longestSeqSum(int[] arr){
		int maxSum=0;
		
		int prev = 0;
		int curr = 0;
		for(int i=0;i<arr.length-1;i++){
			if(arr[i]<arr[i+1]){
			curr = prev + arr[i];
			if(curr > maxSum)
				maxSum = curr;
			  prev = curr;
			}
			else{
			prev = curr;
			
			}
		}
		return maxSum;
		
	}
	
	
	public static void main(String args[]) {
		
		int[] arr = {1,8,2,3};
		
	  System.out.println(" Sum of the longest increasing subSequence is " + new SumOfSubSequence().longestSeqSum(arr));	
	}

}
