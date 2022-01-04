package com.amit.stack;

public class StackOperations {

	public static void main(String[] args) throws Exception {
		StackOperations operations= new StackOperations();
		Stack stack = new Stack(6);
		stack.peek();
		stack.pop();
		stack.push(2);
		stack.push(1);
		stack.push(4);
		stack.push(3);
		stack.push(9);
		stack.push(6);
	//	System.out.println(stack.pop());
	//	System.out.println(stack.pop());
	//	System.out.println(stack.peek());
	//	System.out.println(stack.pop());
		Stack newStack= operations.sortStack(stack);
		System.out.println(newStack.pop());
		System.out.println(newStack.pop());
		System.out.println(newStack.pop());
		System.out.println(newStack.pop());
		System.out.println(newStack.pop());
		System.out.println(newStack.pop());
		System.out.println(newStack.pop());
		int result= operations.evaluatePostFix("921*-8-4+");
		System.out.println("postfix result: "+ result);
	}
	
	/**
	 * Sort elements of a stack
	 * @param stack
	 * @return
	 */
	private Stack sortStack(Stack stack) {
		Stack newStack = new Stack(stack.size());
		if (stack.isEmpty()) {
			System.out.println("stack is empty");
			return newStack;
		}
		while (!stack.isEmpty()) {
			int temp = stack.pop();
			if (newStack.isEmpty() || temp > newStack.peek()) {
				newStack.push(temp);
			} else {
				while (!newStack.isEmpty() && temp < newStack.peek()) {
					stack.push(newStack.pop());
				}
				newStack.push(temp);
			}
		}
		return newStack;
	}
	
	/**
	 * Evaluate postfix expression
	 * @param expression
	 * @return
	 * @throws Exception 
	 */
	private int evaluatePostFix(String expression) throws Exception {
		if (expression == null || expression.isEmpty()) {
			System.out.println("expression is blank");
			return -1000; // dummy number to show that expression is incorrect
		}
		Stack stack = new Stack(expression.length());
		for (int i = 0; i < expression.length(); i++) {
			char c = expression.charAt(i);
			if (!Character.isDigit(c)) {
				int a = stack.pop();
				int b = stack.pop();
				if (c == '+') {
					stack.push(b + a);
				}
				if (c == '-') {
					stack.push(b - a);
				}
				if (c == '*') {
					stack.push(a * b);
				}
				if (c == '/') {
					if (a == 0) {
						throw new Exception("divide by 0 is not possible");
					}
					stack.push(b / a);
				}
			} else {
				stack.push(Character.getNumericValue(c));
			}
		}
		return stack.pop();
	}

}
