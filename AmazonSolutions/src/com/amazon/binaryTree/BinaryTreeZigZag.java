package com.amazon.binaryTree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

import com.amazon.binaryTree.BinaryTree.Node;
/*
		http://www.careercup.com/question?id=6236748675809280: Iterative way left
*/
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
		}
	}
	class Node {
		int nData;
		Node leftNode;
		Node rightNode;
		public Node(int nData) {
			this.nData = nData;
		}

		public Node() {

		}

	}

	public static int height(Node root) {
		int h = 0;
		if (root == null)
			return 0;
		int lHeight = height(root.leftNode);
		int rHeight = height(root.rightNode);
		return lHeight > rHeight ? lHeight + 1 : rHeight + 1;
	}

	public void printZigZag(Node root) {
		int h = height(root);
		boolean leftToRight = true;
		for (int i = 0; i <= h; i++) {
			printZZag(root, i, leftToRight);
			leftToRight = !leftToRight;
		}
	}

	public void printZZag(Node root, int height, boolean leftToRight) {
		if (root == null)
			return;
		if (height == 1)
			System.out.print(" " + root.nData + " ");
		else if (height > 1) {
			if (leftToRight) {
				printZZag(root.leftNode, height - 1, leftToRight);
				printZZag(root.rightNode, height - 1, leftToRight);
			} else {
				printZZag(root.rightNode, height - 1, leftToRight);
				printZZag(root.leftNode, height - 1, leftToRight);

			}
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

public class BinaryTreeZigZag {
	public static void main(String args[]) {
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.insert(1);
		binaryTree.insert(3);
		binaryTree.insert(2);
		binaryTree.insert(-1);
		binaryTree.insert(-4);
		binaryTree.insert(14);
		binaryTree.displayTree();
		binaryTree.printZigZag(binaryTree.root);
	}
}
