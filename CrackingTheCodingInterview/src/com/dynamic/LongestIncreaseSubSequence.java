package com.dynamic;

public class LongestIncreaseSubSequence {
	private static int getLongestSequence(int[] arr){
		int length=0;
		int[] temp = new int[arr.length+1];
		for(int i=0;i<arr.length;i++){
			temp[i] = 1;
		}
		for(int i=1;i<arr.length;i++){
			for(int j=0;j<i;j++){
				if(arr[i] > arr[j] && temp[i] < temp[j] + 1)
				temp[i] = temp[j]+1;
			}
		}
		for(int i=0;i<temp.length;i++){
			if(length < temp[i])
				length = temp[i];
		}
		return length;
	}
	
	public static void main(String args[]) {
		int[] arr = {10, 22, 9, 33, 21, 50, 41, 60};
		System.out.println(" seq is "+ getLongestSequence(arr));
	}
}
