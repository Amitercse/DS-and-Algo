package com.amit.operations;

import com.amit.model.Graph;

public class Main {

	public static void main(String[] args) {
		Graph graph = new Graph(6);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 5);
		graph.addEdge(5, 0);
		graph.printGraph();
		GraphTraversal traversal = new GraphTraversal();
		traversal.traverseBFS(graph);
		traversal.traverseDFS(graph);
		GraphOperations op= new GraphOperations();
		boolean isCyclePresent=op.detectCycle(graph);
		System.out.println("has cycle: "+ isCyclePresent);
		Graph undirectedGraph= buildUndirectedGraph();
		int edgeCount= op.countEdgesinUndirectedGraph(undirectedGraph);
		System.out.println("edge count: "+ edgeCount);
		System.out.println("is tree: "+ op.isTree(graph, 0));
		System.out.println("distance between vertices: "+ op.shortestPathBetweenVertices(undirectedGraph, 0, 7));
	}
	
	private static Graph buildUndirectedGraph()
	{
		Graph graph = new Graph(8);
		graph.addEdgeUndirected(0, 1);
		graph.addEdgeUndirected(0, 4);
		graph.addEdgeUndirected(1, 2);
		graph.addEdgeUndirected(1, 3);
		graph.addEdgeUndirected(4, 2);
		graph.addEdgeUndirected(4, 5);
		graph.addEdgeUndirected(2, 5);
		graph.addEdgeUndirected(5, 6);
		graph.addEdgeUndirected(5, 7);
		graph.addEdgeUndirected(5, 3);
		graph.addEdgeUndirected(6, 7);
		return graph;
	}
}
