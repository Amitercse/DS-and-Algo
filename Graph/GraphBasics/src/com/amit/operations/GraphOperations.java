package com.amit.operations;

import java.util.HashSet;
import java.util.Set;

import com.amit.model.DoublyLinkedList;
import com.amit.model.Graph;
import com.amit.model.Queue;

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
	
	public int countEdgesinUndirectedGraph(Graph g) {
		int size = g.getVertices();
		DoublyLinkedList[] adjacencyList = g.getAdjacencyList();
		int count = 0;
		for (int i = 0; i < size; i++) {
			DoublyLinkedList.Node temp = null;
			if (adjacencyList[i] != null) {
				temp = adjacencyList[i].getHead();
			}
			while (temp != null) {
				count++;
				temp = temp.next;
			}
		}
		return count / 2;
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
	
	public boolean isTree(Graph g, int rootVertex) {
		Queue queue = new Queue(g.getVertices());
		Set<Integer> visited = new HashSet<Integer>();
		queue.enqueue(rootVertex);
		visited.add(rootVertex);
		int visitedCount = 1;
		while (!queue.isEmpty()) {
			int vertex = queue.dequeue();
			DoublyLinkedList.Node temp = null;
			if (g.getAdjacencyList()[vertex] != null) {
				temp = g.getAdjacencyList()[vertex].getHead();
			}
			while (temp != null) {
				if (visited.contains(temp.data)) {
					return false;
				}
				queue.enqueue(temp.data);
				visited.add(temp.data);
				visitedCount++;
				temp = temp.next;
			}
		}
		return (visitedCount != g.getVertices());
	}
	
	public int shortestPathBetweenVertices(Graph g, int source, int destination) {
		int size = g.getVertices();
		Queue queue = new Queue(size);
		Set<Integer> visited = new HashSet<>();
		int[] distance = new int[size];
		if (source == destination) {
			return 0;
		}
		queue.enqueue(source);
		visited.add(source);
		distance[source] = 0;
		while (!queue.isEmpty()) {
			int vertex = queue.dequeue();
			DoublyLinkedList.Node temp = null;
			if (g.getAdjacencyList()[vertex] != null) {
				temp = g.getAdjacencyList()[vertex].getHead();
			}
			while (temp != null) {
				if (!visited.contains(temp.data)) {
					visited.add(temp.data);
					queue.enqueue(temp.data);
					distance[temp.data] = distance[vertex] + 1;
				}
				if (temp.data == destination) {
					return distance[temp.data];
				}
				temp = temp.next;
			}
		}
		return -1;
	}
}
