package com.amazon.binaryTree;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import com.amazon.binaryTree.BinaryTree.Node;


class BinaryTree {
	Node root;
	Node temp;

	public BinaryTree() {

	}

	public BinaryTree(Node root) {
		this.root = null;
	}

	public void insert(int nData) { // Using Recursion // detect duplicate in
									// Binary Tree
		Node newNode = new Node(nData);
		if (root == null) {
			root = newNode;
			// return root.nData;
			// return root.nData;
			return;
		} else {
			Node current = root;
			Node parent;
			while (true) {
				parent = current;
				if (newNode.nData < current.nData)// go left
				{
					current = current.leftNode;
					if (current == null) {
						parent.leftNode = newNode;
						return;
					}
				} else {
					current = current.rightNode;
					if (current == null) {
						parent.rightNode = newNode;
						return;
					}
				}
			}

			/*
			 * Node current = root; Node parent; while (true) { parent =
			 * current; if (newNode.nData < current.nData){ current =
			 * current.leftNode; if(current==null){ parent.leftNode = newNode; }
			 * } else { current = current.rightNode; if(current == null){
			 * parent.rightNode = newNode; } } }
			 */
		}
	}

	/*
	 * public void displayTree(Node node){ Node current = node; if
	 * (current!=null) { displayTree(current.leftNode);
	 * displayTree(current.rightNode); System.out.println("    "+current.nData);
	 * } }
	 */
	
	class Node {
		int nData;
		Node leftNode;
		Node rightNode;

		// boolean isLeftchild;
		public Node(int nData) {
			this.nData = nData;
		}

		public Node() {

		}

	}


	public void displayTree() {
		Stack globalStack = new Stack();
		globalStack.push(root);
		int emptyLeaf = 32;
		boolean isRowEmpty = false;
		System.out
				.println("****......................................................****");
		while (isRowEmpty == false) {

			Stack localStack = new Stack();
			isRowEmpty = true;
			for (int j = 0; j < emptyLeaf; j++)
				System.out.print(' ');
			while (globalStack.isEmpty() == false) {
				Node temp = (Node) globalStack.pop();
				if (temp != null) {
					System.out.print(" ** " + temp.nData);
					localStack.push(temp.leftNode);
					localStack.push(temp.rightNode);
					if (temp.leftNode != null || temp.rightNode != null)
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
}

	
public class BinaryTreeQuestions {
/*
 * 
 * http://www.careercup.com/question?id=50789190341754: Ater Approach: To use HashMap 
 * 	
 */
	
	static void printFirstLast(Node root) {
		Queue<Node> queue = new ArrayDeque<Node>();
		Node first = root;
		while (first != null) {
			System.out.println(" -- " + first.nData + " ");
			if (first.leftNode != null)
				queue.add(first.leftNode);
			if (first.rightNode != null)
				queue.add(first.rightNode);
			first = queue.poll();
		}
	}
	
	static void printNodes(){
		
	}
	
	static int height(Node root){
		
		if(root==null)return 0;
				
		return (1 + Math.max(height(root.leftNode), height(root.rightNode)));
	}
	
	
	static boolean checkIfSameIntegers(Node first,Node second){
		
		Set<Integer> s = new HashSet<Integer>();
		Node root = first;
		while(root!=null){
			s.add(root.nData);
			root = root.leftNode;
		}
		
		root = first;
		while(root!=null){
			s.add(root.nData);
			root = root.rightNode;
		}
		
		
		 root = second.leftNode;
		while(root!=null){
			if(!s.contains(root.nData)){
				return false;
			}root = root.leftNode;
		}
		
		root = second.rightNode;
		while(root!=null){
			if(!s.contains(root.nData)){
				return false;
			}
			root = root.rightNode;
			}
		return true;
		}
		
	
	
	static Node inOrderTraversal(Node root){
		
		Set<Node> hSet  = new HashSet<Node>();
		if(root==null){
			
			return null;
		}
		hSet.add(root);
		//System.out.println(" "+root.nData);
		inOrderTraversal(root.leftNode);
		inOrderTraversal(root.rightNode);
		return root;
	}

	public static void main(String args[]){
		
		BinaryTree binaryTree = new BinaryTree();
		
		binaryTree.insert(1);
		
		binaryTree.insert(3);
		binaryTree.insert(2);
		binaryTree.insert(-1);
		binaryTree.insert(4);
		binaryTree.insert(14);
		binaryTree.insert(24);
		binaryTree.insert(34);
		binaryTree.insert(44);
		
		binaryTree.displayTree();
		BinaryTree secondTree = new BinaryTree();
		secondTree.insert(3);
		secondTree.insert(2);
		secondTree.insert(1);
		secondTree.insert(1);
		secondTree.insert(4);
		
		secondTree.displayTree();
		
//		boolean res = checkIfSameIntegers(binaryTree.root,secondTree.root);
	//	System.out.println(" Any common "+ res);
		
		printFirstLast(secondTree.root);
	}
	
}
