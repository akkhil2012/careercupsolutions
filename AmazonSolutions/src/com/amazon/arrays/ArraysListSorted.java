package com.amazon.arrays;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/*
  http://www.careercup.com/question?id=6243295774638080
*/

public class ArraysListSorted {

	public static void mergerLists(List<int[]> lst){
		Map<Integer,int[]> m = new TreeMap<Integer, int[]>();
	   
		Iterator<int[]> itr = lst.iterator();
		while (itr.hasNext()) {
			int[] is = (int[]) itr.next();
			m.put(is[is.length-1], is);
		}
		
		LinkedList<int[]> fList = new LinkedList<int[]>();
		
		for(Map.Entry<Integer, int[]> s : m.entrySet()){
			fList.add(s.getValue());
		}
		
		Iterator<int[]> itrtr = fList.iterator();
		while (itrtr.hasNext()) {
			int[] temp = itrtr.next();
			for(int t : temp){
			System.out.print(" "+t+" ");
			}
		}
		
		
		
	}
	
	
	public static void main(String args[]) {
		int[] first = {31,32,33,34,35};
		int[] sec = {11,22,33,44,55};
		int[] third = {1,2};
		int[] fourth = {45,56};
		
		List<int[]> lst = new LinkedList<int[]>();
		lst.add(first);
		lst.add(sec);
		lst.add(third);
		lst.add(fourth);
		
		mergerLists(lst);
	}
	
	
	
}
