package com.amit.operations;

import java.util.HashSet;
import java.util.Set;

import com.amit.model.DoublyLinkedList;
import com.amit.model.Graph;
import com.amit.model.Queue;

public class GraphTraversal {

	public void traverseBFS(Graph graph) {
		String result = "";
		Set<Integer> visited = new HashSet<>();
		for (int i = 0; i < graph.getVertices(); i++) {
			if (!visited.contains(i)) {
				result = result + bfsVisit(graph, i, visited);
			}
		}
		System.out.println(result);
	}

	private String bfsVisit(Graph graph, int sourceVertex, Set<Integer> visited) {
		String result = "";
		Queue queue = new Queue(graph.getVertices());
		visited.add(sourceVertex);
		queue.enqueue(sourceVertex);
		while (!queue.isEmpty()) {
			int vertex = queue.dequeue();
			result = result + vertex;
			DoublyLinkedList[] adjacencyList = graph.getAdjacencyList();
			DoublyLinkedList.Node tempNode = null;

			if (adjacencyList[vertex].getHead() != null) {
				tempNode = adjacencyList[vertex].getHead();
				while (tempNode != null) {
					if (!visited.contains(tempNode.data)) {
						visited.add(tempNode.data);
						queue.enqueue(tempNode.data);
					}
					tempNode = tempNode.next;
				}
			}
		}
		return result;
	}
}
