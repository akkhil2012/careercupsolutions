
public class LongestCommonSubString {
	
	
	
	private static int subString(char[] ch1,char[] ch2){
		int max = 0;
		int temp[][] = new int[ch1.length+1][ch2.length+1];
		for(int i=1;i<=ch1.length;i++){
			for(int j=1;j<=ch2.length;j++){
				if(ch1[i-1] == ch2[j-1])
					temp[i][j] = temp[i-1][j-1] + 1;
				if(max<temp[i][j])
					max = temp[i][j];
			}
		}
		return max;
	}
	
	
	
	
	
	
	public static void main(String args[]) {
		
		String str1= "OldSite:GeeksforGeeks.org";
		String str2 = "NewSite:GeeksQuiz.com";
		
		
		
		System.out.println(" Longet common substring is "+ subString(str1.toCharArray(),str2.toCharArray()));
		
	}

}
