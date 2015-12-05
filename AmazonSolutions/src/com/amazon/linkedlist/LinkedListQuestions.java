package com.amazon.linkedlist;

import java.util.Scanner;

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
		System.out.println(" Add Node "+ newNode.nData);
		
	}
	
	public void displayList(Node first){
		if(first==null) return;
		System.out.print(" "+ first.nData+" ");
		displayList(first.next);
	}
	
	
	/*
	 * careercup: http://www.careercup.com/question?id=5660149190492160
	 * Reverse LinkedList in set of K
	 * 
	 */
	public Node reverseAlterKNodes(Node first,int k){
		if(first==null) return null;
		int number = 0;
		Node previous = null;
		Node temp = null;
		Node current = first;
			while (number < k && current!=null) {
				temp = current.next;
				current.next = previous;
				previous = current;
				current = temp;
			}
			if(temp!=null)
				first.next = reverseAlterKNodes(temp, k);
			return previous;
	}
	
	
	
	public void segregateFibbonaciSeries(Node first) {
		Node fNode = new Node();
		Node current = first;
		LinkedList lst1 = new LinkedList();
		LinkedList lst2 = new LinkedList();
		while (current != null) {
			if (isFibonnaciNumber(current.nData)) {
				Node temp = new Node(current.nData);
				current = current.next;
				lst1.addNode(fNode.nData);
				fNode = temp;
				fNode.next = current;
			} else {
				current = fNode.next;
				lst2.addNode(current.nData);
			}
		}
		lst1.displayList(lst1.first);
		System.out.println(" ");
		lst2.displayList(lst2.first);
	}
	
	
	
	boolean isFibonnaciNumber(int num){
		return ((isPerfectSq(5*(num)*(num)-4)) || isPerfectSq(5*(num)*(num)+4));
	}
	
	
	boolean isPerfectSq(int num){
		int temp = (int)Math.sqrt(num);
		if(temp*temp == num)return true;
		else
			return false;
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



public class LinkedListQuestions {
	
	public static void main(String args[]){
		System.out.println(" Create the linked List");
		LinkedList list = new LinkedList();
		
		System.out.println(" enter the length for  linked List");
		/*Scanner scan  = new Scanner(System.in);
		
		int length = scan.nextInt();*/
		
		for(int i=0;i<34;i++){
			//System.out.println(" Enter Node vaues ");
			list.addNode(i);
		}
	//	scan.close();
		
		System.out.println(" Display List ");
		list.displayList(list.first);

		
		System.out.println(" Display List : After Reversal of alternateive k Nodes");
		
	//	list.displayList(list.reverseAlterKNodes(list.first,3));

		System.out.println(" AferSegregating Series");
		
		list.segregateFibbonaciSeries(list.first);
		
		//list.displayList(list.first);
		
		/*Node current = firs
		while (current!=null) {
			System.out.print(" "+current.nData+" ");
			current = current.next;
			
			
		}*/

	}

	
}
