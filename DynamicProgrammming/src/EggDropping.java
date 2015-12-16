
public class EggDropping {
	
	public int minimumAttempts(int floors,int eggs){
		int temp[][] = new int[eggs+1][floors+1];
		int c = 0;
		for(int i=0;i<=floors;i++){
			 temp[1][i] = i;
		}
		
		for(int e=2;e<=eggs;e++){
			for(int f = 1;f <= floors;f++){
				temp[e][f] = Integer.MAX_VALUE;
				for(int k = 1;k<=f ;k++){
					c = 1 + Math.max(temp[e-1][k-1], temp[e][f-k]);
					if(c < temp[e][f])
					{
						temp[e][f] = c;
					}
				}
			}
		}
		return temp[eggs][floors];
	}
	
	public static void main(String args[]) {
		System.out.println("  Minimum number of Attempts are  "+ new EggDropping().minimumAttempts(10, 2));
	}
}
