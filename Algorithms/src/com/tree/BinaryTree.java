package beta.binaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.Map.Entry;



public class BinaryTree<T> {
	Node<T> root;
	Node<T> newNode;
	Node<T> currentNode;

	public BinaryTree() {
		root = null;
	}

	static class Node<T> {
		T data;
		Node<T> left;
		Node<T> right;

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		public Node() {

		}

		public Node(T data) {
			this.data = data;
		}
	}

	public void displayBinaryTree(Node root) {
		Stack globalStack = new Stack();
		globalStack.push(root);
		int emptyLeaf = 32;
		boolean isRowEmpty = false;
		System.out.println("****......................................................****");
		while (isRowEmpty == false) {

			Stack localStack = new Stack();
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
		System.out.println("****......................................................****");
	}

	/*public Node deleteNode(int key) {
		T current = root;
		Node parent = null;
		boolean isLeft = false;
		while (current != null && current.data != key) {
			parent = current;
			if (key < current.data) {
				current = current.left;
				isLeft = true;
			} else {
				current = current.right;
				isLeft = false;
			}
		}
		if (current != null) {
			if (current.left != null && current.right != null) { // Case 1: When
																	// Node to
																	// be
																	// deleted
																	// has TWO
																	// SubTree
				Node successor = findSuccessor(current);
				Node temp;
				if (isLeft) {
					temp = parent.left.left;
					parent.left = successor;
					parent.left.left = temp;
				} else {
					temp = parent.right.left;
					parent.right = successor;
					parent.right.left = temp;

				}
				// temp = null;

			}

			else if (current.right != null) { // Case 2.1: When Node to be
												// deleted has ONE SubTree
				parent.right = current.right;

			} else if (current.left != null) {// Case 2.2: When Node to be
												// deleted has ONE SubTree
				parent.left = current.left;
			} else {
				if (isLeft)
					parent.left = null;
				else
					parent.right = null;

			}

		}

		return null;
	}
*/
	public void printSpiralInwards(Node root) {

		Map<Integer, ArrayList<Node>> mp = new HashMap<Integer, ArrayList<Node>>();

		ArrayList<Node> arrayList = null;
		ArrayList<Node> arrayList1 = null;
		int i = 0;
		if (root == null)
			return;

		Deque<Node> queue = new LinkedList<Node>();
		queue.add(root);
		queue.add(null);
		while (queue.size() > 1) {
			Node temp = queue.peekFirst();

			arrayList = new ArrayList<Node>();
			while (temp != null) {

				temp = queue.pollFirst();
				arrayList.add(temp);
				System.out.println(" " + temp.data);

				if (temp.left != null)
					queue.offerLast(temp.left);
				if (temp.right != null)
					queue.offerLast(temp.right);
				temp = queue.peekFirst();
			}
			mp.put(i++, arrayList);
			temp = queue.peekLast();
			arrayList1 = new ArrayList<Node>();
			while (temp != null) {
				temp = queue.pollLast();
				arrayList1.add(temp);
				System.out.println(" " + temp.data);
				if (temp.right != null)
					queue.offerFirst(temp.right);
				if (temp.left != null)
					queue.offerFirst(temp.left);
				temp = queue.peekLast();
			}
			mp.put(i++, arrayList1);
		}

		Deque<ArrayList<Node>> de = new LinkedList<ArrayList<Node>>();
		de.addAll(mp.values());

		while (!de.isEmpty()) {
			System.out.println(" ");
			ArrayList<Node> first = de.pollFirst();
			Iterator<Node> itr = first.iterator();
			while (itr.hasNext()) {
				System.out.print(" " + itr.next().data);
			}

			System.out.println(" ");
			ArrayList<Node> sec = de.pollLast();
			Iterator<Node> itr1 = sec.iterator();
			while (itr1.hasNext()) {
				System.out.print(" " + itr1.next().data);
			}

		}

	}

	/*
	 * case 1: when right node is NOT null:simply find the left node of the right subTree
	 * 
	 * case 2: when rigth Node is NULL: find the ancetor
	 */
	private Node findSuccessorInBST(Node node,Node root) {
		
		Node current = root;
		Node parent;
		
		if(root==null)return null;
		
		if (String.valueOf(current.data).compareTo(String.valueOf(node.data)) > 0) {
			while (current!=null && String.valueOf(current.data).compareTo(String.valueOf(node.data)) > 0) {
				{
					parent = current;
					current = current.right;
				}
			}
		}else if (String.valueOf(current.data).compareTo(String.valueOf(node.data)) < 0){
			while (current!=null && String.valueOf(current.data).compareTo(String.valueOf(node.data)) < 0) {
				{
					parent = current;
					current = current.left;
				}

			}
			
		}else{
			Node ancestor  = parent;
		}
		Node current = node.right;
		
		
		
		

		if (current.left != null) {
			while (current != null)
				current = current.left;
		} else {
			return current;
		}

		return current;
	}

	// This is done Iteratively
	/*private boolean searchKey(int key) {
		T current = root;
		if (root == null)// case1: Tree NOT Exists
			return false;
		if (root. == key)
			return true; // case2: Tree with one Node and is same as key value

		while (current != null && current.data != key) {
			if (key < current.data)
				current = current.left;
			else
				current = current.right;
		}
		if (current != null) {
			return true;
		}
		return false;
	}

	public boolean searchKeyRec(Node<String> root, T key) {
		if (root == null)
			return false;
		if (key.equals(root.data)) {
			return true;
		} else if (((String) key).compareTo(String.valueOf(root.data)) < 0) {
			return searchKeyRec(root.left, key);
		} else {
			return searchKeyRec(root.right, key);
		}

	}


	public int addGreaterValues(Node root, int sum) {
		if (root == null)
			return 0;

		
		 * Node temp = root;
		 * 
		 * if(root.data > temp.data)
		  sum += root.data;

		System.out.println(" sum is " + sum + " For Node " + root.data);

		if (root.left != null && root.left.data > root.data)
			sum += addGreaterValues(root.left, sum);

		if (root.right != null && root.right.data > root.data)
			sum += addGreaterValues(root.right, sum);

		return sum - root.data;

	}

	public void addGreaterValItr(Node root) {
		// int sum = 0;
		Node current = root;
		while (current != null) {

			Node temp = current;
			while (current.left != null && current.left.data > current.data) {
				current.data += current.left.data;
				current = current.left;
			}

			int sum = current.data;
			current = temp;

			while (current.right != null && current.right.data > current.data) {
				sum += current.right.data;
				current = current.right;
			}

			temp.data = sum;

			if (temp.left != null) {
				current = temp.left;

			}

			if (temp.right != null) {
				current = temp.right;
			}

		}
	}
*/
	
	/*** INSERT INTO THE BINARY TREE (NOT BST)  ****/
	
	public void insertNode(T data) {
		Node<T> newNode = (Node<T>) new Node<T>();
		newNode.data = data;
		Node<T> parent;
		Node<T> current = root;
		if (root == null)
			root = newNode;
		else {
			while(true){
				parent = current;
				if (String.valueOf(current.data).compareTo(String.valueOf(data))>0){
					current = current.left;
					if (current == null) {
						parent.left = newNode;
						return;
					}
				}else{
					current = current.right;
					if (current == null) {
						parent.right = newNode;
						return;
					}
				}
			}
		
		}
	}

	public static void main(String args[]) {

		BinaryTree<Integer> binaryTree = new BinaryTree<Integer>();
		
		BinaryTree<String> stringBinaryTree = new BinaryTree<String>();
		
		stringBinaryTree.insertNode("DataStructures");
		stringBinaryTree.insertNode("are");
		stringBinaryTree.insertNode("awsome");
		
		stringBinaryTree.insertNode("thing");
		stringBinaryTree.insertNode("to");
		stringBinaryTree.insertNode("study");
		
		stringBinaryTree.insertNode("and");
		stringBinaryTree.insertNode("understand");
		stringBinaryTree.insertNode("thouroughly");
		
		
		binaryTree.insertNode(4);
		binaryTree.insertNode(3);
		binaryTree.insertNode(5);
		binaryTree.insertNode(2);
		binaryTree.insertNode(6);
		binaryTree.insertNode(4);
		binaryTree.insertNode(7);
		binaryTree.insertNode(11);
		binaryTree.insertNode(16);
		binaryTree.insertNode(7);
		binaryTree.insertNode(23);

		stringBinaryTree.displayBinaryTree(stringBinaryTree.root);

		/*
		 * System.out.println(" Is the Key present: sing Iteration "+
		 * binaryTree.searchKey(228));
		 * 
		 * System.out.println(" Is the Key present : using Recursion "+
		 * binaryTree.searchKeyRec(binaryTree.root, 14));
		 */
		// binaryTree.deleteNode(13);

		// System.out.println(" After Node deletion..............");

		// binaryTree.displayBinaryTree(binaryTree.root);

		// binaryTree.addGreaterValItr(binaryTree.root);

		//binaryTree.printSpiralInwards(binaryTree.root);

	}

}
