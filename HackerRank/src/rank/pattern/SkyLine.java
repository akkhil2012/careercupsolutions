package rank.pattern;

import java.util.Scanner;

public class SkyLine {

	public boolean isSkyLinePerfect(int[] buildings) {

		if (buildings.length == 1 || buildings.length == 2)
			return false;

		if (buildings.length % 2 == 0)
			return false;

		for (int i = 0; i < buildings.length / 2; i++) {
			if (buildings[i] >= buildings[i + 1])
				return false;
		}

		return isPalindrome(buildings);
	}

	public boolean isPalindrome(int[] buildings) {
		int i = 0;
		int j = buildings.length - 1;
		while (i < j) {
			if (buildings[i] != buildings[j])
				return false;
			i++;
			j--;
		}
		return true;

	}

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		System.out.println(" Input thge number");
		int num = scan.nextInt();
		
		int[] arr = new int[]{1,2,3,2,1};
		for (int i = 0; i < num; i++) {
			arr[i] = scan.nextInt();
		}
	//	new SkyLine().isSkyLinePerfect(arr);
		System.out.println(new SkyLine().isSkyLinePerfect(arr));
	}


}
