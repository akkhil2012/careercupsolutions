public class EditDistance {

	private final int EDIT_COST = 1;

	public int minEdits(char[] ch1, char[] ch2) {
		int min = 0;
		int[][] temp = new int[ch1.length + 1][ch2.length + 1];
		for (int i = 0; i < temp.length; i++) {
			temp[i][0] = i;
		}
		for (int j = 0; j < temp[0].length; j++) {
			temp[0][j] = j;
		}
		for (int i = 1; i < ch1.length; i++)
			for (int j = 1; j < ch2.length; j++) {
				if (ch1[i] == ch2[j]) {
					temp[i][j] = temp[i - 1][j - 1];
				} else {
					temp[i][j] = min(temp[i - 1][j - 1] + 1, temp[i - 1][j]
							+ EDIT_COST, temp[i][j - 1] + EDIT_COST);
				}
			}
		return min;
	}

	private int min(int a, int b, int c) {

		int temp = Math.min(a, b);

		return Math.min(temp, c);

	}

	public static void main(String args[]) {

		String str1 = "sunday";
		String str2 = "saturday";

		System.out.println(" Minimum edits needed are "
				+ new EditDistance().minEdits(str1.toCharArray(),
						str2.toCharArray()));

	}

}
