package com.misc;

import java.util.Scanner;

public class Solution {
        static int height(int n){
        	int temp = 1;
        	if(n==0)return 0;
        	for(int i=0;i<n;i++){
        		temp = 2*temp;
        		temp = temp +1;
        	}
        	
      return temp;  	
	}
     
     
     /*static int heightAfter(int s,int n){
    	 if(s==n) return 0;
    	 int temp = 1;
    	 int height =( temp+1) + (2*temp);
    	 return heightAfter(s+1, n)- height;
     }*/

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            System.out.println(height(n));
        }

	}
}
