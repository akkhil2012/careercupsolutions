package com.amazon.arrays;

public class ArrayCharacterCom {
	

	private static void combinationRec(char[] arr,int low,int high) {
	//int k = 0;
	
		StringBuffer stringBuffer = new StringBuffer();
	//for (int j =0; j >= =arr.length; j--) {
	if(high >= low){	
	for(int i=low;i<=high-i;i++){
		stringBuffer.append(arr[i]);
		
	}
	System.out.print("  " + stringBuffer.toString() + "  ");
	System.out.println(" ");
	combinationRec(arr, low, high-1);
	
	combinationRec(arr, low+1, high-1);
	
	combinationRec(arr, low+1, high);
	
	}
	
	//k++;
//	}
	}
	
	private static void combination(char[] arr) {
		
		combinationRec(arr,0,arr.length-1);
		/*while (k <= arr.length) {
			for (int i = arr.length-k; i >= 0; i--) {
				for (int j = k; j <= i && j != i; j++) {
					System.out.print("  " + arr[j] + "  ");
				}
				System.out.println(" ");
			}
			k++;
		}*/
	}
	
	
	
	public static void main(String args[]){
		
		char[] arr = {'A','B','C','D'};
		combination(arr);
		
	}

}
