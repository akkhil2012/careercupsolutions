package com.dynamic;

public class KnapSackProblem {
	public int getMaxVal(int[] wt,int[] val,int W){
		int[][] temp = new int[val.length+1][W+1];
		for(int i=0;i<=val.length;i++){
			for(int j=0;j<=W;j++){
				if(i == 0 || j==0){
					temp[i][j] = 0;
					continue;
				}
				if(j - wt[i - 1]< 0){
					temp[i][j] = temp[i-1][j];
				}else{
					temp[i][j] = Math.max(temp[i-1][j], temp[i-1][j - wt[i-1]] + val[i-1]); 
				}
			}
		}
		return temp[val.length][W];
	}
	
	public static void main(String args[]) {
		int val[] = {60, 100, 120};
        int wt[] = {10, 20, 30};
        /*new KnapSackProblem().getMaxVal(wt,val,50);*/
        System.out.println(" Maximum sum is "+  new KnapSackProblem().getMaxVal(wt,val,50));
	}
}
