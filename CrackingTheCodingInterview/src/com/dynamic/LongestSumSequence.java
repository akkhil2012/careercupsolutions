package com.dynamic;

public class LongestSumSequence {
	private static int getLongestSequence(int[] arr){
		int length=0;
		int[] temp = new int[arr.length+1];
		for(int i=0;i<arr.length;i++){
			temp[i] = arr[i];
		}
		for(int i=1;i<arr.length;i++){
			for(int j=0;j<i;j++){
				if(arr[i] > arr[j] && temp[i] < temp[j] + arr[i])
				temp[i] = temp[j]+arr[i];
			}
		}
		for(int i=0;i<temp.length;i++){
			if(length < temp[i])
				length = temp[i];
		}
		return length;
	}
	
	public static void main(String args[]) {
		int[] arr = {1, 101, 2, 3, 100, 4, 5};
		System.out.println(" seq is "+ getLongestSequence(arr));
	}
	
}
