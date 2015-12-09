package com.list;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class LinkedList{
	Node first;
	public LinkedList() {
	  first = null;
	}
	/*** Add Node ****/
	public void addNode(int data){
		Node newNode = new Node(data);
		if(first==null)
			first = newNode;
		else{
			Node current = first;
			while(current.next!=null){
				current= current.next;
			}
			current.next = newNode;
		}
		//System.out.println(" Add Node "+ newNode.nData);
		
	}
	
	public void displayList(Node first){
		if(first==null) return;
		System.out.print(" "+ first.nData+" ");
		displayList(first.next);
	}
	
	/*
	 * 
	 * Using an auxiliary DS
	 */
	public void removeDuplicatesWithDS(Node first){
		Map<Integer,Boolean> mp = new HashMap<Integer,Boolean>();
		Node current = first;
		Node prev = null;
		while (current != null) {
			if(mp.containsKey(current.nData)) {
				prev.next = current.next;
			}
			else{
				  mp.put(current.nData, true);
				  prev = current;
			}
			current = current.next;
		}
		
		System.out.println(" size is  "+mp.size());
	}
}

class Node{
	
	public int getnData() {
		return nData;
	}
	public void setnData(int nData) {
		this.nData = nData;
	}
	
	int nData;
	Node next;
	Node(){
		
	}
	Node(int data){
		this.nData = data;
		this.next=null;
	}
}
	
public class RemoveDuplicates {

	public static void main(String args[]) {
		
		LinkedList list = new LinkedList();
		
		list.addNode(1);
		list.addNode(2);
		list.addNode(2);
		list.addNode(3);
		list.addNode(3);
		
		list.displayList(list.first);
		
		list.removeDuplicatesWithDS(list.first);
		
		list.displayList(list.first);
		
	}
	
	
	
}
