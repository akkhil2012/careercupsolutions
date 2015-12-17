public class FibonaaciSeries {

	private static int getNumber(int num) {
		int a = 1;
		int b = 1;
		int c = 1;

		for (int i = 2; i <= num; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		return c;
	}

	public static void main(String args[]) {

		System.out.println("Fibb serries value is  " + getNumber(5));
	}
}
