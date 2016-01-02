public class RotateByNinty {

	public void rotate(int[][] mat) {
		
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(" " + mat[i][j] + " ");
			}
			System.out.println(" ");
		}
		
		System.out.println(" After rotation ");

		int rowLen = mat.length - 1;
		int colLen = mat[0].length - 1;

		int i = 0;
		int j = 0;

		while (i <=mat.length / 2) {
			for (j = i; j < mat.length - i; j++) {
				int temp = mat[i][j];
				mat[i][j] = mat[i][colLen - j];
				mat[i][colLen - j] = mat[rowLen - i][colLen - j];
				mat[rowLen - i][colLen - j] = mat[rowLen - j][i];
				mat[rowLen - j][i] = temp;
			}
		i++;
		}

		for (i = 0; i < mat.length; i++) {
			for (j = 0; j < mat[0].length; j++) {
				System.out.print(" " + mat[i][j] + " ");
			}
			System.out.println(" ");
		}

	}

	public static void main(String args[]) {

		int mat[][] = { { 1, 2, 3 }, { 5, 6, 7 }, { 9, 10, 11 } };

		new RotateByNinty().rotate(mat);
	}

}
