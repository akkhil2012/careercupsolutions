
public class LongestCommonSubString {
	public int lcSubString(char[] first,char[] second){
		int max=0;
		int temp[][] = new int[first.length][second.length];
		for(int i=1;i<temp.length;i++){
			for(int j=1;j<temp[0].length;j++){
				if(first[i-1] == second[j-1])
					temp[i][j] =  temp[i-1][j-1] + 1;
				    if(max < temp[i][j])
				    	max = temp[i][j];
			}
		}
		return max;
	}
	
	public static void main(String args[]) {
		String first = "OldSite:GeeksforGeeks.org";
		String second = "NewSite:GeeksQuiz.com";
		System.out.println(" ---  " + new LongestCommonSubString().lcSubString(first.toCharArray(), second.toCharArray()));
	}
}
