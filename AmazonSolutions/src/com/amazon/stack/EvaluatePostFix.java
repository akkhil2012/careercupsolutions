package com.amazon.stack;

import java.util.Stack;

public class EvaluatePostFix {
	public int evaluate(String str) {
		char[] chArray = str.toCharArray();
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
				stack.push(Character.getNumericValue(str.charAt(i)));
			} else {
				int temp = solveExpression(stack.pop(), stack.pop(),
						str.charAt(i));
				stack.push(temp);
			}
		}
		return stack.pop();
	}

	private int solveExpression(int a, int b, char op) {
		if (op == '*')
			return a * b;
		else if (op == '+')
			return a + b;
		else if (op == '-')
			return a - b;
		else if (op == '/')
			return a / b;
		return 0;
	}

	public static void main(String args[]) {
		String str = "423+*";
		System.out.println(" value for postFix expression is "
				+ new EvaluatePostFix().evaluate(str));
	}
}
