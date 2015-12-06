package com.amazon.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ArrayDuplicate {
	public static void resolveDuplicate(int[] arr) {
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		Set st = new HashSet<Integer>();
		int count = 1;
		for (int i = 0; i < arr.length - 1; i++) {
			st.add(arr[i]);
		}
		System.out.println(" -- ");
		Iterator<Integer> t = st.iterator();
		while (t.hasNext()) {
			System.out.print(" " + t.next() + " ");
		}
	}

	public static void main(String args[]) {
		int arr[] = { 1, 1, 2, 3, 4, 5, 6 };
		new ArrayDuplicate().resolveDuplicate(arr);
	}
}
