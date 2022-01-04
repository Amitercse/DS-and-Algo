package com.amit.stack;

public class StackOperations {

	public static void main(String[] args) {
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

}
