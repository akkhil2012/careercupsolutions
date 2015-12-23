package com.list;

import java.awt.geom.CubicCurve2D;

class LinkedList<T> {
	Node<T> first = null;

	LinkedList() {

	}

	LinkedList(Node<T> node) {
		this.first = node;
	}

	public void addNode(T nData) {
		Node<T> newNode = new Node<T>(nData);
		if (first == null) {
			first = newNode;
		} else {
			Node<T> current = first;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
	}

	public void printList(Node<T> head) {
		Node<T> current = head;
		while (current != null) {
			System.out.print(" " + current.nData + " ");
			current = current.next;
		}
	}

	
	private void reverseList(Node first){
		
		Node prev = null;
		Node nextNode = null;
		Node temp;
		Node current = first;
		
		while(current!=null){
			temp = current.next;
		   current.next = prev;
		   prev = current;
		   current = temp;
			/*temp = current;
			current = prev;*/
		}
		first = prev;
		
		System.out.println(" ");
		 current = first;
/*		 

		while (current!=null) {
			
			System.out.print(" --> "+ current.nData+" <--");
			current = current.next;
		}
		*/
		return;
		
	}
	
	
	int max = Integer.MIN_VALUE;
	public Node delGreaterNodes(Node<Integer> first){
		if(first == null) return null;
		
		Node nextNode = delGreaterNodes(first.next);// MOST IMPORTANT RECURSION
		
		if(first.nData > max)
			max = first.nData;
		
		if(max >first.nData)
		  return nextNode;
		
		first.next = nextNode;
		return first;
		
		
		
		
	/*	 Node current = first;
		while (current.next!=null) {
			max = first.nData;
			if((int)current.next.nData<max){
				Node temp = current.next;
				current.next = current.next.next;
				temp = null;
			}
			System.out.println(" ** "+ current.nData+" ** ");
			current = current.next;
		}
		*/
		
	}
	
	
	
	
	
	
	
	public void insertAt(int data) {
		Node newNode = new Node(data);
		Node prev = null;

		Node current = first;

		if (first == null) {
			first = newNode;
			return;
		}

		if (first.next == null) {
			if ((int) first.nData < data) {
				first.next = newNode;
				newNode.next = null;
			} else {
				newNode.next = first;
				first = newNode;
			}
			return;
		}

		while (current != null && (int) current.nData <= data) {

			prev = current;
			current = current.next;
		}

		if (current == null) {
			current.next = newNode;
		} else {
			newNode.next = current;
			prev.next = newNode;
		}

	}

	public static void main(String args[]) {

		LinkedList<Integer> list = new LinkedList<Integer>();

		// LinkedList<String> sList = new LinkedList<String>();

		list.addNode(12);
		list.addNode(15);
		list.addNode(10);
		list.addNode(11);
		list.addNode(5);
		list.addNode(6);
		list.addNode(2);
		list.addNode(3);
		/*
		 * list.addNode(3); list.addNode(1); list.addNode(13); list.addNode(21);
		 */

		/*
		 * sList.addNode("akkhil"); sList.addNode("Kumar");
		 * sList.addNode("Gupta");
		 */
		// sList.printList(sList.first);
		list.printList(list.first);
		list.insertAt(12);
		System.out.println(" After insertion in sorted list");
		list.printList(list.first);

		Node root = list.delGreaterNodes(list.first);
		System.out.println(" After deleting ------the greater Nodes ");
		list.printList(root);
		
	}

}

class Node<T> {
	T nData;
	Node next;
	Node random;

	Node(T nData) {
		this.nData = nData;
		this.next = null;
		this.random = null;
	}

	Node() {

	}
}
