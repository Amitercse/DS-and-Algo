package com.amit.queue;

public class QueueOperations {

	public static void main(String[] args) {
		QueueOperations operations= new QueueOperations();
		operations.generateBinaryNumbers(7);
	}
	
	/**
	 * Generate binary numbers from 1 to n
	 * @param n
	 */
	private void generateBinaryNumbers(int n) {
		Queue queue = new Queue(n);
		String[] output = new String[n];
		queue.enque("1");
		int i = 0;
		while (i < n) {
			String element = queue.deque();
			queue.enque(element + "0");
			queue.enque(element + "1");
			output[i] = element;
			i++;
		}
		for (String s : output) {
			System.out.print(s + "\t");
		}
	}
}
