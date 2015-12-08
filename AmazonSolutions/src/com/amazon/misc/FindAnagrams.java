package com.amazon.misc;

import java.util.ArrayList;

public class FindAnagrams {
	public static ArrayList<String> anagrams(String str) {
		ArrayList<String> res = new ArrayList<String>();
		if (str.length() == 1) {
			res.add(str);
		} else if (str.length() > 1) {
			int lastIndex = str.length() - 1;
			String last = str.substring(lastIndex);
			String rest = str.substring(0, lastIndex);
			res = merge(anagrams(rest), last);
		}
		return res;
	}

	public static ArrayList<String> merge(ArrayList<String> list, String c) {
		ArrayList<String> res = new ArrayList<String>();
		for (String s : list) {
			for (int i = 0; i < s.length(); ++i) {
				String ps = new StringBuffer(s).insert(i, c).toString();
				res.add(ps);
			}
		}
		return res;
	}

	public static void main(String args[]) {
		String str = "akhil";
		ArrayList<String> res = new FindAnagrams().anagrams(str);
		for (String it : res) {
			System.out.println(" " + it + " ");
		}
	}
}
