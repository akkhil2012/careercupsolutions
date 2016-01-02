
public class LongestIncreasingSubSequence {
	public int lis(int[] arr){
	int max = 0;
	int[] ls = new int[arr.length];
	for(int i=0;i<arr.length;i++){
		ls[i] = 1;
	}
	for(int i=1;i<arr.length;i++){
		for(int j = 0;j<i;j++){
			  if(arr[j]<arr[i] && (ls[j]+1)-ls[i]>0){
				  ls[i] = ls[i] +1;
			  }
		}
	}
	
	for(int i=0;i<ls.length;i++){
		if(ls[i] > max)
			max = ls[i];
	}
		return max;
	}
	
	public static void main(String args[]) {
		int[] arr = {10, 22, 9, 33, 21, 50, 41, 60, 80};
		System.out.println(" Longest increasing seq. has length  "+new LongestIncreasingSubSequence().lis(arr));
	}
}
