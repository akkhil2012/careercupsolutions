package com.adt;

import java.util.Stack;

class SortStack{
	
	public Stack<Integer> sort(Stack<Integer> stack){
		Stack<Integer> stack2 = new Stack<Integer>();
		while(!stack.isEmpty()){
		  int x = stack.pop();
			while(!stack2.isEmpty() && stack2.peek() < x){
				stack.push(stack2.pop());
			}
			stack2.push(x);
		}
		
		return stack;
	}
}

public class AscendingStack {
	public static void main(String args[]) {
	Stack<Integer> fStack = new Stack<Integer>();
	fStack.add(1);
	fStack.add(4);
	fStack.add(3);
	fStack.add(5);
	fStack.add(15);
	fStack.add(9);
	fStack.add(35);
	for (int i=0;i<fStack.size();i++) {
		System.out.println(" "+ fStack.get(i) +" ");
	}
	Stack<Integer> nStack = new SortStack().sort(fStack);
	System.out.println(" --------- ");
	while (!nStack.isEmpty()) {
		System.out.println(" "+ nStack.pop() +" ");
	}
}
}
