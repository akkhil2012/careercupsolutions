package com.recursion;

public class AllAdjacentCombinations {
	
	public void getCombitaion(int[] arr,int[] result,int k,int pos,int r){
		
		if(pos==arr.length){
			for(int i=0;i<r;i++){
				System.out.println(result[i]+" ");
			}
			System.out.println("");
			return;
		}
		
		for(int i=pos;i<pos+k && i<arr.length;i++){
			result[r] = formNumber(arr,pos,i);
			getCombitaion(arr, result, k, i+1, r+1);
		}
	}
	
	private int formNumber(int input[],int start,int end){
		int num = 0;
		for(int i=start;i<=end;i++){
			num = num * 10 + input[i];
		}
		return num;
	}
	
	
	
	public static void main(String  args[]) {
		AllAdjacentCombinations adc = new AllAdjacentCombinations();
		
		int input[] = {1,2,3,4,5};
        int result[] = new int[input.length];
        adc.getCombitaion(input,result,3,0,0);
		
		
	}

}
