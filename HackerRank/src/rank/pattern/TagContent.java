package rank.pattern;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagContent {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		while (testCases > 0) {
			String line = in.nextLine();
			Matcher m = Pattern.compile("<(.+)>(([^<>]+))</\\").matcher(line);
			if (m.find()) {
				String str = m.replaceAll("");
				System.out.println("-- " + str);
			}
			testCases--;
		}
	}
}
