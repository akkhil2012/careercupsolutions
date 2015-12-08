package com.amazon.arrays;

/*
http://www.careercup.com/question?id=5766344614084608
*/

public class CountNumOfZerosInArray {
	public static int countZeros(int[] arr){
		int count = 0;
		int low = 0; int mid;
		int high = arr.length-1;
		while(low<=high){
			mid = (high+low)/2;
			if(arr[mid]<1){
				low = mid+1;
			}else{
				high = mid-1;
			}
		}
		return low;
	}
	
	public static void main(String args[]) {
	
		int [] arr = {0,0,0,0,1,1};
		System.out.println(" Number of zeros is "+ new CountNumOfZerosInArray().countZeros(arr));
		
		
	}
}
