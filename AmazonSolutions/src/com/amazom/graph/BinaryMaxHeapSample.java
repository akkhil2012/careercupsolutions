package com.amazom.graph;

import java.util.ArrayList;
import java.util.List;

class BinaryMaxHeap<T> {
	private List<Node> allNodes = new ArrayList<Node>();

	class Node {
		int weight;
		T data;
	}

	public T extractMax() {

		int size = allNodes.size() - 1;

		T max = allNodes.get(0).data;

		int lastNodeWeight = allNodes.get(size).weight;
		allNodes.get(0).weight = lastNodeWeight;
		allNodes.get(0).data = allNodes.get(size).data;
		allNodes.remove(size);

		int currentIndex = 0;
		size--;

		while (true) {
			int left = 2 * currentIndex + 1;
			int right = 2 * currentIndex + 2;
			if (left > size)
				break;
			if (right > size) {
				right = left;
			}

			int largerIndex = allNodes.get(left).weight >= allNodes.get(right).weight ? left
					: right;
			if (allNodes.get(currentIndex).weight < allNodes.get(largerIndex).weight) {
				Node temp = allNodes.get(currentIndex);
				temp.data = allNodes.get(currentIndex).data;
				temp.weight = allNodes.get(currentIndex).weight;

				allNodes.get(currentIndex).data = allNodes.get(largerIndex).data;
				allNodes.get(currentIndex).weight = allNodes.get(largerIndex).weight;

				allNodes.get(largerIndex).data = temp.data;
				allNodes.get(largerIndex).weight = temp.weight;
				currentIndex = largerIndex;
			} else {
				break;
			}
		}
		return max;

	}

	public void add(int weight, T data) {
		Node node = new Node();
		node.weight = weight;
		node.data = data;
		allNodes.add(node);
		int size = allNodes.size();
		int current = size - 1;
		int parentIndex = (current - 1) / 2;
		while (parentIndex >= 0) {
			Node parentNode = allNodes.get(parentIndex);
			Node currentNode = allNodes.get(current);
			if (parentNode.weight < currentNode.weight) {
				/* swap(parentNode,currentNode); */
				data = parentNode.data;
				weight = parentNode.weight;

				parentNode.data = currentNode.data;
				parentNode.weight = currentNode.weight;

				currentNode.data = data;
				currentNode.weight = weight;

				current = parentIndex;
				parentIndex = (parentIndex - 1) / 2;
			} else {
				break;
			}
		}
	}

	public void displayHeap() {
		for (Node n : allNodes) {
			System.out.println(" " + n.data + " -- " + n.weight);
		}
	}

	private void swap(Node first, Node second) {

		T data = first.data;
		int weight = second.weight;

		first.data = second.data;
		first.weight = second.weight;

		second.data = data;
		second.weight = weight;

	}

}

public class BinaryMaxHeapSample {

	public static void main(String args[]) {

		BinaryMaxHeap<String> binaryMaxHeap = new BinaryMaxHeap<String>();

		BinaryMaxHeap<Integer> binaryMaxHeapInt = new BinaryMaxHeap<Integer>();

		binaryMaxHeap.add(3, "Tushar");
		binaryMaxHeap.add(4, "Ani");
		binaryMaxHeap.add(8, "Vijay");
		binaryMaxHeap.add(10, "pramila");
		binaryMaxHeap.add(5, "Roy");
		binaryMaxHeap.add(6, "NTF");

		binaryMaxHeap.displayHeap();

		System.out.println(" Max is " + binaryMaxHeap.extractMax());

		System.out.println(" HEAP WITH DATATYPE : Integer");

		binaryMaxHeapInt.add(3, 007);
		binaryMaxHeapInt.add(4, 1007);
		binaryMaxHeapInt.add(1, 4007);
		binaryMaxHeapInt.add(6, 2007);
		binaryMaxHeapInt.add(9, 507);

		binaryMaxHeapInt.displayHeap();

		System.out.println(" Max is " + binaryMaxHeapInt.extractMax());

	}

}
