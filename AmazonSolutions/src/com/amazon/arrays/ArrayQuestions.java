package com.amazon.arrays;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class Array {
/*
careercup: http://www.careercup.com/question?id=5637103067070464
Alter solution: To usr Trie + Min Heap for top 100 elements
*/

	public void getMaxOccurance(String arr[]) {
		Map<String, Integer> keysMap = new TreeMap<String, Integer>();
		int count = 1;
		for (String str : arr) {
			if (keysMap.containsKey(str)) {
				keysMap.put(str, count++);
			} else {
				keysMap.put(str, count);
			}
		}

		Map<Integer, String> valuesMap = new TreeMap<Integer, String>(
				Collections.reverseOrder());
		for (Map.Entry<String, Integer> s : keysMap.entrySet()) {
			valuesMap.put(s.getValue(), s.getKey());
		}
		for (Map.Entry<Integer, String> v : valuesMap.entrySet()) {
			System.out.println(" " + v.getKey() + " -- " + v.getValue());
		}
	}

}

public class ArrayQuestions {
	public static void main(String args[]) {
		System.out.println(" Enter String Stream  ");
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		int i = 0;
		String strArray[] = new String[input];
		for (; i < strArray.length;) {
			strArray[i++] = scan.next();
		}
		System.out.println(" Occurance is ");
		new Array().getMaxOccurance(strArray);
	}
}
