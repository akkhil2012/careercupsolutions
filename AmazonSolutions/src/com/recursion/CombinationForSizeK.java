package com.recursion;

public class CombinationForSizeK {
	    public void combination(int arr[],int k){
	        int result[] = new int[k];
	        combinationUtil(arr,k,0,result,0);
	    }

	    private void combinationUtil(int arr[],int k, int pos,int result[],int start){
	        if(pos == k){
	            for(int i=0; i < k; i++){
	                System.out.print(result[i] + " ");
	            }
	            System.out.print("\n");
	            return;
	        }
	    	
	    	/*if(pos == k)
	    		return;
	    	*/
	        for(int i=start; i < arr.length; i++){
	            result[pos] = arr[i];
	            System.out.println("--- "+result[pos]+"---");
	            combinationUtil(arr,k,pos+1,result,i+1);
	        }
	    }
	    
	    public static void main(String args[]){
	    	CombinationForSizeK kk = new CombinationForSizeK();
	        int arr[] = {1,2,3};
	        kk.combination(arr, 2);
	    }
	}

	/*public void combination(int[] arr, int k) {

		int result[] = new int[k];

		combinationUtil(arr, k, 0, result, 0);

	}

	private void combinationUtil(int[] arr, int k, int pos, int[] result,
			int start) {
		if (pos == k) {
			for (int i = 0; i < k; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println("\n");
			return;
		}

		for (int i = start; i < arr.length; i++) {
			result[pos] = arr[i];
			combinationUtil(arr, k, pos + 1, result, start + 1);
		}

	}

	public static void main(String args[]) {
		CombinationForSizeK kk = new CombinationForSizeK();
		int arr[] = { 1, 2, 3, 4 ,5};
		kk.combination(arr, 3);
	}

}
*/