package com.list;


import java.awt.geom.CubicCurve2D;
import java.util.Queue;

class LinkedList<T> {
	Node<T> first = null;
	LinkedList(Node<T> node) {
		this.first = node;
	}

/******Add Node at End ********************/
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
/****** Print LinkedList Iteratively ******************/
	public void printList(Node<T> head) {
		Node<T> current = head;
		while (current != null) {
			System.out.print(" " + current.nData + " ");
			current = current.next;
		}
	}


/****** Print LinkedList Recursively ******************/
	public void printList(Node<T> head) {
	 if(head == null)
	 return;
	 
	 System.out.print(" " + current.nData + " ");
	 printList(head.next);
	}

	
/******  reverse list Iteratively ******************/	
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
		}
		first = prev;
		return;
	}
	
	
/******  reverse Recursively ********************/


????????????????????????? TO DO 

/***********************************************/
	/*
	 * 
	 * Recursively : O(n)
	 */
	public boolean checkIfPalinDrome(LinkedList<Integer> lst){
		Node current = first;
		Node headFirst = first;
		Node prev = first;
		Node secHead;
		while(current!=null && current.next!=null){
			current = current.next.next;
			prev = prev.next;
		}
		
		if(current!null)// To check if List is Odd in length
		   secHead = prev.next;
		else
		   secHead = prev;
		   
		current = secHead;`	
		Node nextNode = null;
		Node previous = null;
		while(current!=null){
			nextNode = current.next;
			current.next = previous;
			previous = current;
			current = nextNode;
		}
		secHead = previous;
		
		return compareLists(headFirst,secHead);
	}
	/************* TO DO Alternative way: non0recursive ***********/
	
boolean compareLists(struct node* head1, struct node *head2)
{
    struct node* temp1 = head1;
    struct node* temp2 = head2;
 
    while (temp1 && temp2)
    {
        if (temp1->data == temp2->data)
        {
            temp1 = temp1->next;
            temp2 = temp2->next;
        }
        else return false;
    }
 
    /* Both are empty reurn 1*/
    if (temp1 == NULL && temp2 == NULL)
        return true;
 
    /* Will reach here when one is NULL
      and other is not */
    return false;
}

/********* LinkedList To Tree Conversion   TO DO ?????????????????? *******************/
	
	public void ListToTreeConversion(Node first,BNode root){
		Queue<BNode> queue = new java.util.LinkedList<BNode>();
		
		if(first==null){
			root = null;
			return;
		}
		root = new BNode((int)first.nData);
		queue.add(root);
		first = first.next;
		while(first!=null){
			BNode parent = queue.peek();
			queue.poll();
			BNode leftchild = null,rightChild = null;
			leftchild = new BNode((int)first.nData);
			queue.add(leftchild);
			first = first.next;
			if(first!=null){
				rightChild = new BNode((int)first.nData);
				queue.add(rightChild);
				first = first.next;
			}
			parent.left = leftchild;
			parent.right = rightChild;
		}
		preOrder(root);
	}
	


  /********** InOrder Traversal Recursivley ***********/
	public void inOrder(BNode node){
		if(node!=null){
			inOrder(node.left);
			System.out.println("~~ "+ node.data+" ~~ ");
			inOrder(node.right);
		}
	}
	
 /********** InOrder Traversal Iteratively ***********	????????????????????????/ TO DO ************/
	
	public void preOrder(BNode node){
		if(node!=null){
			System.out.println("~~ "+ node.data+" ~~ ");
			preOrder(node.left);
			
			preOrder(node.right);
		}
	}
	
	
	
	public void pairWiseSwap(Node first){
			Node temp = first;
			while(temp != null && temp.next!=null){
				int k = (int) temp.nData;
				temp.nData = temp.next.nData;
				temp.next.nData = k;
				temp = temp.next.next;
			}
			
			printList(first);
			
	}
	
	
	private Node frontBackSplit(Node first){
		if(first==null)
			return null;
		Node slow = first;
		Node fast = first.next;
		while(fast!=null && fast.next!=null){
			slow = slow.next;
			fast = fast.next;
		}
		Node newHead = slow.next;
		slow.next = null;
		return newHead;
	}
	
	
	
	
	
	int max = Integer.MIN_VALUE;
	public Node delGreaterNodes(Node<Integer> first){
		if(first == null) return null;
		Node nextNode = delGreaterNodes(first.next);
		if(first.nData > max)
			max = first.nData;
		if(max >first.nData)
		  return nextNode;
		first.next = nextNode;
		return first;
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

		list.addNode(1);
		list.addNode(2);
		list.addNode(3);
		list.addNode(4);
		list.addNode(5);
		list.addNode(6);
		list.addNode(7);
		list.addNode(8);
		/*
		 * list.addNode(3); list.addNode(1); list.addNode(13); list.addNode(21);
		 */

		/*
		 * sList.addNode("akkhil"); sList.addNode("Kumar");
		 * sList.addNode("Gupta");
		 */
		// sList.printList(sList.first);
		list.printList(list.first);
		/*list.insertAt(12);
		System.out.println(" After insertion in sorted list");
		list.printList(list.first);

		Node root = list.delGreaterNodes(list.first);
		System.out.println(" After deleting ------the greater Nodes ");
		list.printList(root);*/

		
//		list.checkIfPalinDrome(list);
		BNode root = new BNode();
		
/*		list.ListToTreeConversion(list.first, root);
		
		System.out.println(" After List to Tree Conversion");
*/		
//		list.inOrder(root);

		System.out.println("<<<>>>");
		
		list.pairWiseSwap(list.first);
		
		
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



class BNode {
	
	BNode left;
	BNode right;
	int data;
	
	public BNode(int data) {
		this.data = data;
	} 

	public BNode(){
		
	}
	
	
}
