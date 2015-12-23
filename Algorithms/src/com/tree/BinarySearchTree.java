package com.tree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {

	Node root;
	
	
	public BinarySearchTree() {
		root = null;
	}
	
	public void addNode(int data) {
		Node newNode = new Node(data);

		if (root == null) {
			root = newNode;
			System.out.println(" new Node is " + root.data);
		} else {
			Node temp = root;
			if (newNode.data < root.data) {
				Node parent = root;
				while (root != null) {
					parent = root;
					root = root.left;
				}
				parent.left = newNode;
				root = temp;
			} else if (newNode.data > root.data) {
				Node parent = null;
				while (temp != null) {
					parent = temp;
					temp = temp.right;
				}
				parent.right = newNode;
			}
		}
	}
	
	
	
	public boolean isBST(Node root){
		return isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	
	public boolean isBST(Node root,int min,int max){
		if(root==null) return true;
		if(root.data>max || root.data <=min)
			return false;
		return isBST(root.left, min, root.data) && isBST(root.right, root.data, max);
	}
	
	
	public int convertToChildSumTree(Node root){
		if(root==null) return 0;
		
		convertToChildSumTree(root.left);
		convertToChildSumTree(root.right);
		root.data = (root.left==null?root.data:root.left.data) + (root.right==null?root.data:root.right.data);
		return root.data;
	}
	
	public boolean BSTOneChildTraversal(int[] arr){
		
		for(int i=0;i<(arr.length-1)/2;i++){
			if(arr[2*i]<arr[i] && arr[2*i+1]>arr[i])
			 return false;
		}
 return true;		
		
	}
	
	
	public void boundryTraversal(Node root){ // NODES ORDER IS NOT CORRECT
		
		System.out.print(" "+ root.data);
		
		printLeftBoundry(root.left);
		printRightBoundry(root.right);
	//	printLeafs(root);
		
	}
	
	private void printLeftBoundry(Node root){
		if(root ==  null) return;
		System.out.print(" "+ root.data);
			 if(root.left!=null && root.right!=null)
			{
				if(root.left.right == null &&  root.left.left == null
						&& root.right.right == null &&  root.right.left == null){
					System.out.print(" "+ root.left.data+" "+ root.right.data);
				}else{
					System.out.print(" "+ root.left.data);
				}
			}
			 else if(root.left!=null || root.right!=null){
					if(root.left!=null)
					System.out.print(" "+ root.left.data);
					else if(root.right!=null)
						System.out.print(" "+ root.right.data);
			 }
	}
	
	
private void printRightBoundry(Node root){
		
		if(root ==  null) return;
		
		System.out.print(" "+ root.data);
		
		 if(root.left!=null && root.right!=null)
			{
				if(root.left.right == null &&  root.left.left == null
						&& root.right.right == null &&  root.right.left == null){
					System.out.print(" "+ root.left.data+" "+ root.right.data);
				}else{
					System.out.print(" "+ root.left.data);
				}
			}
		 else if(root.left!=null || root.right!=null){
				if(root.right!=null)
				System.out.print(" "+ root.right.data);
				else if(root.left!=null)
					System.out.print(" "+ root.left.data);
		 }
		
	}

public Node arrayToTree(int[] arr){
	
 root = new Node();
	
	for(int i=0;i<(arr.length-1)/2;i++){
		root.data = arr[i];
		root.left = new Node();
		root.left.data = arr[2*i+1];
		
		root.right = new Node();
		root.right.data = arr[2*i+2];
		
	}
	
	return root;
	
	
}








	
	private int height(Node root){
		if(root == null) return 0; 
		int lHeight =  1 + height(root.left);
		int rHeight = 1+ height(root.right);
		return lHeight > rHeight ? lHeight : rHeight;
	}

public void connectnodesAtSameLevel(Node root){
	int h  = height(root);
	System.out.println(" Levels in tree "+ h);
	for(int i=1;i<=h;i++){
	}
}


public void convertTreeToDLL(Node root){
	
	Node prev = new Node();
	
	convertTreeToDLL(root,prev);
	
	
}


public void print(Node root){
    Node curr = null;
    while(root != null){
        curr = root;
        System.out.print(root.data + " ");
        root = root.right;
    }
    System.out.println();
    root = curr;
    while(root != null){
        System.out.print(root.data + " ");
        root = root.left;
    }
}

private void convertTreeToDLL(Node root,Node prev){
		if(root==null)return;
		convertTreeToDLL(root.left, prev);
		if(prev!=null){
			prev.right = root;
			root.left = prev.left;
			prev = root;
		}else{
			prev = root;
		}
	convertTreeToDLL(root.right, prev);
}

public void spiralTraversal(Node root){
	Queue<Node> q = new LinkedList<Node>();
	boolean level = false;	
	q.add(root);
//	q.add(null);
	while(!q.isEmpty()){
	
		if(q.peek()==null)
			level = !level;
		
		root = q.poll();
		System.out.print(" --"+ root.data);
		
		if(level){
		if(root.left!=null)
			q.add(root.left);
		if(root.right!=null)
			q.add(root.right);
		    q.add(null);
		}else{
			if(root.left!=null)
				q.add(root.left);
			if(root.right!=null)
				q.add(root.right);
			q.add(null);
		}
		
		
	/*	if(q.peek()==null){
			q.poll();
		   level = !level;
		}else{
			Node temp = q.poll();
			System.out.println("--"+ temp.data);
			if(level){
			if(temp.left!=null)
				q.add(temp.left);
			if(temp.right!=null)
				q.add(temp.right);
			}else{
				if(temp.right!=null)
    				q.add(temp.right);
    			if(temp.left!=null)
    				q.add(temp.left);
			}
			q.add(null);
		}*/
	}
}




public void preOrderArrayToTree(Node root,int[] arr){
	int index = 0;
	preOrder(arr,root,Integer.MIN_VALUE,Integer.MAX_VALUE,index);
	displayTree(root);
}

public Node preOrder(int[] arr,Node root,int min,int max,int index){
	Node node = new Node();
	node.data = arr[index];
	if(arr.length <= index)
		return null;
	if(arr[index] < min || arr[index] >= max)
	  return null;
	index++;
	node.left = preOrder(arr,root, min, node.data, index);
	node.right = preOrder(arr,root,  node.data,max,index);
	return node;
}

	public void levelOrderTraversal(Node root) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		Node node = null;
		q.add(node);
		int level = 0;
		while (!q.isEmpty()) {
			if (q.peek() == null) {
				q.poll();
				level++;
			System.out.println(" ");
			} else {
				root = q.poll();
				System.out.print("~~ " + root.data);
				if (root.left != null)
					q.add(root.left);
				if (root.right != null)
					q.add(root.right);
				q.add(null);
			}
		}
	}
	
	
	public void constructTreeFromPreOrder(int[] pre){
		
		
		
	}
	
	
	
	public void displayTree(Node root) {
		Stack<Node> globalStack = new Stack<Node>();
		globalStack.push(root);
		int emptyLeaf = 32;
		boolean isRowEmpty = false;
		System.out
				.println("****......................................................****");
		while (isRowEmpty == false) {

			Stack<Node> localStack = new Stack<Node>();
			isRowEmpty = true;
			for (int j = 0; j < emptyLeaf; j++)
				System.out.print(' ');
			while (globalStack.isEmpty() == false) {
				Node temp = (Node) globalStack.pop();
				if (temp != null) {
					System.out.print(" ** " + temp.data);
					localStack.push(temp.left);
					localStack.push(temp.right);
					if (temp.left != null || temp.right != null)
						isRowEmpty = false;
				} else {
					System.out.print("--");
					localStack.push(null);
					localStack.push(null);
				}
				for (int j = 0; j < emptyLeaf * 2 - 2; j++)
					System.out.print(' ');
			}
			System.out.println();
			emptyLeaf /= 2;
			while (localStack.isEmpty() == false)
				globalStack.push(localStack.pop());
		}
		System.out
				.println("****......................................................****");
	}


	public static void main(String args[]) {
		
		BinarySearchTree bTree = new BinarySearchTree();
		
		bTree.addNode(50);
		/*bTree.addNode(3);
		bTree.addNode(2);
		bTree.addNode(6);
		bTree.addNode(5);
		bTree.addNode(4);
		bTree.addNode(11);
		*/
		bTree.root.left = new Node();
		bTree.root.left.data = 8;
		
		bTree.root.left.left = new Node();
		bTree.root.left.left.data = 3;
		
		bTree.root.left.right = new Node();
		bTree.root.left.right.data = 5;
		
		bTree.root.right = new Node();
		bTree.root.right.data = 2;
		
		bTree.root.right.right = new Node();
		bTree.root.right.right.data = 30;
		
		bTree.root.right.left = new Node();
		bTree.root.right.left.data = 1;
		
		bTree.root.right.left.left = new Node();
		bTree.root.right.left.left.data = 100;
		
		/*bTree.addNode(1);
		
		bTree.displayTree(bTree.root);
		
		bTree.root.left.data = 52;*/
		//bTree.root.right.data = 20;
		
		/*System.out.println(" Is tree a BST "+ bTree.isBST(bTree.root));
		
		bTree.displayTree(bTree.root);*/

//System.out.println(" Root to Sum "+ bTree.convertToChildSumTree(bTree.root));		
		

//System.out.println(" Does internal nodes have only one child "+ bTree.BSTOneChildTraversal(arr));
/*System.out.println(" Boundry Traversal "); 
bTree.boundryTraversal(bTree.root);*/
//bTree.connectnodesAtSameLevel(bTree.root);
/*System.out.println("  Array to tree traversal ");
bTree.levelOrderTraversal(bTree.root);
bTree.displayTree(bTree.root);*/
int arr[] = {10, 5, 1, 7, 40, 50};


/*bTree.preOrderArrayToTree(bTree.root,arr);
System.out.println(" AFter preOrder Traversal");*/

bTree.displayTree(bTree.root);

System.out.println(" Spiral Order Traversal ");

//bTree.spiralTraversal(bTree.root);

System.out.println("Convert Tree to DLL ");

bTree.convertTreeToDLL(bTree.root);

bTree.print(bTree.root);

	}
}

class Node{
	Node left;
	Node right;
	int data;
	Node(int data){
		this.data = data;
	}
	Node(){
	}
}

/*
 * 
 *   Doubly Linked List
 */
class DoublyLinkedList {
	Node first;

	public DoublyLinkedList() {
		first = null;
	}

	/*public void addNode(int nData) {
		Node newNode = new Node(nData);
		Node current = first;
		if (first == null)
			first = newNode;
		else {
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
			//newNode.next = null;
			newNode.previous = current;
		}
	}*/
}

