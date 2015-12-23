package com.list;

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

		while (current != null && (int) current.nData < data) {

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

		list.addNode(32);
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
