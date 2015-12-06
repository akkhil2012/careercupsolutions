package com.amazon.arrays;

import java.util.HashMap;
import java.util.Map;

public class ArrayRepetitive {
	public static void getRepetitive(char[] arr) {
		Map<Character, Integer> m = new HashMap<Character, Integer>();
		int count = 1;
		for (char i = 0; i < arr.length; i++) {
			if (m.containsKey(arr[i])) {
				m.put(arr[i], m.get(arr[i]) + 1);
			} else {
				m.put(arr[i], count);
			}
		}
		for (Map.Entry<Character, Integer> s : m.entrySet()) {
			System.out.print(" " + s.getKey() + "" + s.getValue());
		}
	}

	public static void main(String args[]) {
		char[] arr = { 'a', 'a', 'b', 'c', 'b', 'b', 'd', 'd' };
		getRepetitive(arr);
	}
}
