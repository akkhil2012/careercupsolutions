package com.misc;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SuzukaXOR {

	public List<Integer> getNumberCount(int[] arr,int l,int r,int x){
		List res = new LinkedList<Integer>();
		
		int lower_min = arr[0];
		int upper_min = arr[l+1];
		
		int lower_z = 0;
		int upper_z = 0;
		for(int i=0;i<=l;i++){
			if(arr[i]<lower_min){
				lower_min = arr[i];
			}
		}

		for(int i=0;i<=l;i++){
			if((arr[i]^x) < upper_min){
				upper_min = arr[i];
				 lower_z = arr[i]; 
			}
		}
		
		res.add(lower_z);
		for(int i=l+1;i<r;i++){
			if(arr[i]<upper_min){
				upper_min = arr[i];
			}
		}

		for(int i=l+1;i<=r;i++){
			if((arr[i]^x) < upper_min){
				upper_min = arr[i];
				 upper_z = arr[i]; 
			}
		}
		res.add(upper_z);
		return res;
	}
	
	
	
	public static void main(String args[]) {
		
		Scanner scan = new Scanner(System.in);
		
		
		
		int N = scan.nextInt();
		int[] arr = new int[N];
		for(int i=0;i<N;i++){
			arr[i] = scan.nextInt(); 
		}
		
		int tCases = scan.nextInt();
		for(int i = 0;i<tCases;i++){
		 List<Integer> lst = new SuzukaXOR().getNumberCount(arr, scan.nextInt(), scan.nextInt(), scan.nextInt());
		 System.out.println(" "+lst.get(0) +" "+ lst.get(1));
		}
	}
}
