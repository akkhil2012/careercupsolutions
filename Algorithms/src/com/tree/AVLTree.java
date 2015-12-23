package com.tree;

import java.util.Stack;


/*
 * 
 * AVLTree:
 * A Balanced binary Search Tree: A height balanced(difference between left subtree and right subtree differ by at most 1) binary search tree 
 * Balanced by Rotation of the nodes which violates the above condition.
 * Single Rotations: 
 *     (LL Rotation)By insertion of the node into the left subtree of the left child of Node
 *     (RR Rotation)By insertion of the node into the right subtree of the right child of Node
 *  Double Rotation:
 *     (LR Rotation)By insertion of the node into the right subtree of the LEFT child of Node
 *     (RL Rotation)By insertion of the node into the left subtree of the RIGHT child of Node   
 */
public class AVLTree {
	
	AVLNode root;
	AVLNode newNode;
	AVLNode currentNode;
	
	public AVLTree() {
		root = null;
	}
	
	private int setHeight(AVLNode root){
		if(root == null) return 0;
		return 1 + Math.max((root.left!=null?root.left.height:0), (root.right!=null?root.right.height:0));
	}
	
	
	static class AVLNode{
		int height;
		int data;
		AVLNode left;
		AVLNode right;
		
		public AVLNode(int data) {
			this.data = data;
			this.height =0;
		}
	}
	
	public int insertNode(int data) {
		newNode = new AVLNode(data);
		if (root == null) { // If Tree is NOT yet created
			root = newNode;
			root.height = 0;
			return newNode.data;
		} else {
			currentNode = root;
			AVLNode parentNode = currentNode;
			while(currentNode!=null){
				if (data <= currentNode.data) {
					parentNode = currentNode;
					parentNode.height =parentNode. height+1;
					currentNode = currentNode.left;
					
				} else {
					parentNode = currentNode;
					parentNode.height =parentNode. height+1;
					currentNode = currentNode.right;
					
				}
			}
			
			if(parentNode.left==null && parentNode.right==null){ // CASE 1: When the Node is leaf Node
			if(parentNode.data <= data){
				parentNode.right = newNode;
			}
			if(parentNode.data > data){
				parentNode.left = newNode;
			}
			}
			
			else if(parentNode.right==null){
				parentNode.right = newNode;
			}
			else if(parentNode.left==null){
				parentNode.left = newNode;
			}
/*********************** Check for iF any InBalance is Introduced ************************/
			if(parentNode.left.height - parentNode.right.height == 2){
				if(data < parentNode.left.data){
					rotateWithLeftChild();
				}
				else{
					rotateLeftRight();
				}
				
			}
			
			if(parentNode.left.height - parentNode.right.height == -2){
				if(data > parentNode.right.data){
					rotateWithRightChild(parentNode.right);
				}
				else{
					rotateRightLeft();
				}
				
			}
			
			
			
			return newNode.data;
		}
	}
	
	
	public boolean checkIfUnbalaced(AVLNode node){
		if(node.left.height - node.right.height == 2)
			return true;
		return false;
	}
	
	
	public void displayTree(){
		displayTree(root);
	}
	
	
	public void displayTree(AVLNode current) {
		//current = root;
	   if(current!=null){
		   System.out.print(" "+ current.data+" ");
		   displayTree(current.left);
		   displayTree(current.right);
	   }
		
	}
	
	public void displayAVLTree(AVLNode root) {
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
				AVLNode temp = (AVLNode) globalStack.pop();
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
		AVLTree avlTree = new AVLTree();
		avlTree.insertNode(12);
		avlTree.insertNode(12);
		avlTree.insertNode(12);
		avlTree.insertNode(12);
		avlTree.insertNode(12);
		avlTree.insertNode(12);
		avlTree.insertNode(12);
		System.out.println(" Check if unbalanced "+ avlTree.checkIfUnbalaced(avlTree.root));
		System.out.println(" Display The AVL Tree ");
		avlTree.displayAVLTree(avlTree.root);
	}
	
}
