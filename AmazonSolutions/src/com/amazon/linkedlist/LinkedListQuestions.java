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
	
}



class Node{
	
	int nData;
	Node next;
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
		Scanner scan  = new Scanner(System.in);
		
		int length = scan.nextInt();
		
		for(int i=0;i<length;i++){
			System.out.println(" Enter Node vaues ");
			list.addNode(scan.nextInt());
		}
		scan.close();
		
		System.out.println(" Display List ");
		list.displayList(list.first);

		
		System.out.println(" Display List : After Reversal of alternateive k Nodes");
		
		list.displayList(list.reverseAlterKNodes(list.first,3));
		
		/*Node current = firs
		while (current!=null) {
			System.out.print(" "+current.nData+" ");
			current = current.next;
			
			
		}*/

	}

	
}
