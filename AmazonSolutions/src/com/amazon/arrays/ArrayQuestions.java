package com.amazon.arrays;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

<<<<<<< HEAD
=======
class Array {
/*
careercup: http://www.careercup.com/question?id=5637103067070464
Alter solution: To usr Trie + Min Heap for top 100 elements
*/
>>>>>>> 845ff02553135c341f353467044fcaf4f2a5492b

class Array{
	
	
	/**
	 * 
	 * 
	 * 
	 * http://www.careercup.com/question?id=5634253624705024...TO DO
	 */
/*public int countNumber(int[] arr,int num){
int count = 0;

int lo = countForNumber(arr,num);
if(lo < arr.length && arr[lo]!=num){
	return 0;
}
int hi = countForNumber(arr,num+1);
return hi-lo;

 }


	private int countForNumber(int[] arr,int num) {
		int lo =0;
		int hi = arr.length - 1;
		
		
		
		
		
	}*/
	
	
	
	
	public void getMaxOccurance(String arr[]) {
		Map<String, Integer> keysMap = new TreeMap<String, Integer>();
		int count = 1;
		for (String str : arr) {
			if (keysMap.containsKey(str)) {
				keysMap.put(str, count++);
			} else {
				keysMap.put(str, count);
			}
		}
		
		Map<Integer, String> valuesMap = new TreeMap<Integer, String>(Collections.reverseOrder());
		for (Map.Entry<String, Integer> s : keysMap.entrySet()) {
			valuesMap.put(s.getValue(), s.getKey());
		}
		for (Map.Entry<Integer, String> v : valuesMap.entrySet()) {
			System.out.println(" " + v.getKey() + " -- " + v.getValue());
		}
	}
	
}



public class ArrayQuestions {

	
	
	
	public static void main(String args[]){
		System.out.println("Enter Array");

		Scanner scan = new Scanner(System.in);
		
		/*String in = scan.next();
		
		int arr[] = new int[in.length()];
		
		System.out.println(" Input array ");
		
		for(int i=0;i<in.length();i++){
			arr[i] = Character.getNumericValue(in.charAt(i));
			System.out.print(" "+arr[i]+" ");
		}
		
		System.out.println(" Enter the element to be searched ");
		
		int ele = scan.nextInt();*/
		
		System.out.println(" Enter String Stream  ");
		
		int input = scan.nextInt();
		
		int i = 0;
		
		String strArray[] = new String[input];
		
		for(;i<strArray.length;){
		strArray[i++] = scan.next(); 
		}
		//System.out.println(" Number of times a number "+ele +" exists is "+ new Array().countNumber(arr,ele));
		
		System.out.println(" Occurance is ");
		new Array().getMaxOccurance(strArray);
		
	}
	
}
