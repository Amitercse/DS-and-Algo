package com.amit.operations;

import com.amit.model.DoublyLinkedList;
import com.amit.model.Graph;

public class GraphOperations {

	public boolean detectCycle(Graph g) {
		int vertices = g.getVertices();
		boolean[] visited = new boolean[vertices];
		boolean[] recursiveVisit = new boolean[vertices];
		for (int i = 0; i < vertices; i++) {
			if (cycle(g, i, visited, recursiveVisit)) {
				return true;
			}
		}
		return false;
	}

	private boolean cycle(Graph g, int sourceVertex, boolean[] visited, boolean[] recursiveVisit) {
		if (recursiveVisit[sourceVertex]) {
			return true;
		}
		if (visited[sourceVertex]) {
			return false;
		}

		visited[sourceVertex] = true;
		recursiveVisit[sourceVertex] = true;

		DoublyLinkedList.Node temp = null;
		if (g.getAdjacencyList()[sourceVertex].getHead() != null) {
			temp = g.getAdjacencyList()[sourceVertex].getHead();
		}
		while (temp != null) {
			if (cycle(g, temp.data, visited, recursiveVisit)) {
				return true;
			}
			temp = temp.next;
		}
		recursiveVisit[sourceVertex] = false;
		return false;
	}

}
