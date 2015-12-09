package com.adt;

import java.util.Stack;

class MyQueue {
	Stack<Integer> stackFirst;
	Stack<Integer> stackSec;

	public MyQueue() {
		stackFirst = new Stack<Integer>();
		stackSec = new Stack<Integer>();
	}

	public void add(int data) {
		stackFirst.push(data);
	}

	public int remove() {
		if (!stackSec.isEmpty()) {
			return stackSec.pop();
		}
		while (!stackFirst.isEmpty()) {
			stackSec.push(stackFirst.pop());
		}
		return stackSec.pop();
	}
}

public class StacksAsQueue {
	public static void main(String arsg[]) {
		MyQueue myQueue = new MyQueue();
		myQueue.add(11);
	}

}
