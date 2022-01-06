package com.amit.operations;

import com.amit.model.Graph;

public class Main {

	public static void main(String[] args) {
		Graph graph= new Graph(6);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 5);
		graph.addEdge(5, 0);
		graph.printGraph();
	}
}
